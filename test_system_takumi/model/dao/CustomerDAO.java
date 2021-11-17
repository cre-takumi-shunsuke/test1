/*
 * customer
 * model.dao.UserDAO.java
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;

/**
 * m_userテーブルのDAOです
 * @author emBex Education
 */
public class CustomerDAO {

	/**
	 * ユーザID・パスワードをもとにログイン認証を行う。
	 *
	 *
	 * @param user_Id ユーザID
	 * @param password パスワード
	 * @return 認証成功の場合 true、そうでない場合 false
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean loginCheck(String userId, String password) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダへの値の設定
			pstmt.setString(1, userId);
			pstmt.setString(2, password);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			System.out.println("sss");
			// 結果の操作
			if (res.next()) {
				return true;
			}
		}
		return false;
	}

	public List<CustomerBean> selectAll() throws ClassNotFoundException, SQLException {
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		String sql = "SELECT * FROM m_customer";

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			// 結果の操作
			while (res.next()) {
				res.getInt("customer_id");
				res.getString("user_id");

				CustomerBean user = new CustomerBean();
				user.setCustomerId(res.getInt("customer_id"));
				user.setUserId(res.getString("user_id"));
				list.add(user);
			}
		}
		return list;
	}

	public CustomerBean select(int customer_id)
			throws SQLException, ClassNotFoundException {

		CustomerBean customer = new CustomerBean();
		String sql = "SELECT * FROM m_customer WHERE customer_id = ?";
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, customer_id);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();
			// 結果の操作
			while (res.next()) {
				customer.setCustomerId(res.getInt("customer_id"));
				customer.setUserId(res.getString("user_id"));

			}
		}
		return customer;
	}

	public int update(CustomerBean customer) throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "UPDATE m_customer SET nendo = ?, customer_code = ?, buy_point = ?, pos_point = ? ,user_id = ? WHERE customer_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			// DTOからのデータの取り出し
			int customer_id = customer.getCustomerId();
			String userid = customer.getUserId();
			String nendo = customer.getNendo();
			String customer_code = customer.getCustomer_code();
			int buy_point = customer.getBuy_point();
			int pos_point = customer.getPos_point();

			// プレースホルダへの値の設定
			pstmt.setString(1, userid);
			pstmt.setInt(2, customer_id);
			pstmt.setString(3, nendo);
			pstmt.setString(4, customer_code);
			pstmt.setInt(5, buy_point);
			pstmt.setInt(6, pos_point);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();

		}

		return processingNumber;
	}

	public int insert(CustomerBean customer) throws SQLException, ClassNotFoundException {
		int count = 0; //処理件数
		int autoIncrementKey = 1;

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO m_customer VALUE( ?,?,?,?), java.sql.Statement.RETURN_GENERATED_KEYS")) {

			// DTOからのデータの取り出し
			int customer_id = autoIncrementKey;
			String userid = customer.getUserId();
			String nendo = customer.getNendo();
			String customer_code = customer.getCustomer_code();
			int buy_point = customer.getBuy_point();
			int pos_point = customer.getPos_point();

			// プレースホルダへの値の設定
			pstmt.setString(1, userid);
			pstmt.setInt(2, customer_id);
			pstmt.setString(3, nendo);
			pstmt.setString(4, customer_code);
			pstmt.setInt(5, buy_point);
			pstmt.setInt(6, pos_point);
			// getGeneratedKeys()により、Auto_IncrementされたIDを取得する
			ResultSet res = pstmt.getGeneratedKeys();

			if (res.next()) {
				autoIncrementKey = res.getInt(1);
			}
			// SQLステートメントの実行
			count = pstmt.executeUpdate();
		}

		return count;
	}

}