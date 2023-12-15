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

public class AccountPSTMTDAOImpl implements AccountDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AccountPSTMTDAOImpl() {
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("prop/mysql.properties"));
			conn = DriverManager.getConnection(
				prop.getProperty("url"),
				prop
			);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(AccountDTO account) {
		// 작성
		try {
			String sql = "INSERT INTO tbl_account VALUES (?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAno());
			pstmt.setString(2, account.getOwner());
			pstmt.setInt(3, account.getBalance());
			pstmt.setString(4, account.getPassword());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
		}
	}

	@Override
	public int update(AccountDTO account) {
		int result = 0;
		// 작성
		String sql = "UPDATE tbl_account SET balance = ? WHERE ano = ?";
		// TODO
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account.getBalance());
		pstmt.setString(2, account.getAno());

		pstmt.executeUpdate();

		return result;
	}

	@Override
	public AccountDTO selectAccount(String ano) {
		AccountDTO account = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				account = getAccount(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
		}
		return account;
	}
	
	public AccountDTO getAccount(ResultSet rs) throws SQLException {
		AccountDTO account = null;
		// 작성
		account = new AccountDTO(
			rs.getString(1),
			rs.getString(2),
			rs.getInt(3),
			rs.getString(4)
		);
		return account;
	}
	@Override
	public AccountDTO selectAccount(String ano, String password) {
		AccountDTO account = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = ? AND password = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				account = getAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {}
		}
		return account;
	}

}







