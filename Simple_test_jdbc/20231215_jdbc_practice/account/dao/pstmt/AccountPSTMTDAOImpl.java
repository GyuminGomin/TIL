package account.dao.pstmt;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import account.dao.AccountDAO;
import account.dto.AccountDTO;
import utils.DBUtil;

public class AccountPSTMTDAOImpl implements AccountDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public void insert(AccountDTO account) {
		// 작성
		try {
			String sql = "INSERT INTO tbl_account VALUES (?,?,?,?)";
			conn = DBUtil.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAno());
			pstmt.setString(2, account.getOwner());
			pstmt.setInt(3, account.getBalance());
			pstmt.setString(4, account.getPassword());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
		}
	}

	@Override
	public int update(AccountDTO account) {
		int result = 0;
		// 작성
		String sql = "UPDATE tbl_account SET balance = ? WHERE ano = ?";
		conn = DBUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account.getBalance());
			pstmt.setString(2, account.getAno());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
		}

		return result;
	}

	@Override
	public AccountDTO selectAccount(String ano) {
		AccountDTO account = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = ?";
		conn = DBUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);

			rs = pstmt.executeQuery();
			account = getAccount(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			*/
			DBUtil.close(rs, pstmt);
		}
		return account;
	}
	
	public AccountDTO getAccount(ResultSet rs) throws SQLException {
		AccountDTO account = null;
		// 작성
		if (rs.next()) {
			account = new AccountDTO(
				rs.getString(1),
				rs.getString(2),
				rs.getInt(3),
				rs.getString(4)
			);
		}
		return account;
	}
	@Override
	public AccountDTO selectAccount(String ano, String password) {
		AccountDTO account = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = ? AND password = ?";
		conn = DBUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			account = getAccount(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt);
		}
		return account;
	}

}







