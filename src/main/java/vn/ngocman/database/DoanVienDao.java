package vn.ngocman.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DoanVienDao {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QLI_DOAN_VIEN;";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public static Connection getConnection(String dbURL, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
	
	public static void themDoanVien(DoanVien doanVien) {
		try {
			// connnect to database 'testdb'
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			// crate statement
			Statement stmt = conn.createStatement();
	        String sqlInsert = String.format("INSERT INTO [dbo].[DOAN_VIEN]\r\n"
	        		+ "           ([MA_DOAN_VIEN]\r\n"
	        		+ "           ,[MA_CHI_DOAN]\r\n"
	        		+ "           ,[MA_CHUC_VU]\r\n"
	        		+ "           ,[TEN_DOAN_VIEN]\r\n"
	        		+ "           ,[NGAY_SINH]\r\n"
	        		+ "           ,[GIOI_TINH]\r\n"
	        		+ "           ,[DIEN_THOAI])\r\n"
	        		+ "     VALUES (\r\n"
	        		+ "           '%s'\r\n"
	        		+ "           ,'%s'\r\n"
	        		+ "           ,'%s'\r\n"
	        		+ "           ,'%s'\r\n"
	        		+ "           ,'%s'\r\n"
	        		+ "           ,'%s'\r\n"
	        		+ "           ,'%s')\r\n"
	        		+ "", doanVien.getMaDoanVien(), doanVien.getMaChiDoan(), doanVien.getMaChucVu(), doanVien.getTenDoanVien(), doanVien.getNgaySinh(), doanVien.getGioiTinh(), doanVien.getDienThoai());
	        int numberRowsAffected = stmt.executeUpdate(sqlInsert);
			stmt.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void suaDoanVien(DoanVien doanVien) {
		try {
			// connnect to database 'testdb'
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			// crate statement
			Statement stmt = conn.createStatement();
	        String sqlInsert = String.format("UPDATE [dbo].[DOAN_VIEN]\r\n"
	        		+ "   SET [MA_CHI_DOAN] = '%s'\r\n"
	        		+ "      ,[MA_CHUC_VU] = '%s'\r\n"
	        		+ "      ,[TEN_DOAN_VIEN] = '%s'\r\n"
	        		+ "      ,[NGAY_SINH] = '%s'\r\n"
	        		+ "      ,[GIOI_TINH] = '%s'\r\n"
	        		+ "      ,[DIEN_THOAI] = '%s'\r\n"
	        		+ " WHERE [MA_DOAN_VIEN] = '%s'", doanVien.getMaChiDoan(), doanVien.getMaChucVu(), doanVien.getTenDoanVien(), doanVien.getNgaySinh(), doanVien.getGioiTinh(), doanVien.getDienThoai(), doanVien.getMaDoanVien());
	        stmt.executeUpdate(sqlInsert);
			stmt.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

	public static void xoaDoanVien(String maDoanVien) {
		try {
			// connnect to database 'testdb'
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			// crate statement
			Statement stmt = conn.createStatement();
	        String sqlDelete = String.format("DELETE FROM [dbo].[DOAN_VIEN]\r\n"
	        		+ " WHERE [MA_DOAN_VIEN] = '%s'", maDoanVien);
	        stmt.executeUpdate(sqlDelete);
			stmt.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static List<DoanVien> layDanhSachDoanVien() {
		List<DoanVien> doanViens = new ArrayList<DoanVien>();
		try {
			// connnect to database 'testdb'
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			// crate statement
			Statement stmt = conn.createStatement();
			// get data from table 'student'
			ResultSet rs = stmt.executeQuery("SELECT DV.MA_DOAN_VIEN, DV.MA_CHI_DOAN, DV.MA_CHUC_VU, DV.TEN_DOAN_VIEN, DV.NGAY_SINH, DV.GIOI_TINH, DV.DIEN_THOAI, CD.TEN__CHI_DOAN, CV.TEN_CHUC_VU\r\n"
					+ "FROM DOAN_VIEN DV\r\n"
					+ "INNER JOIN CHI_DOAN CD ON DV.MA_CHI_DOAN = CD.MA_CHI_DOAN\r\n"
					+ "INNER JOIN CHUC_VU CV ON DV.MA_CHUC_VU = CV.MA_CHUC_VU");
			// show data
			DoanVien doanVien = null;
			while (rs.next()) {
				doanVien = new DoanVien();
				doanVien.setMaDoanVien(rs.getString(1));
				doanVien.setMaChiDoan(rs.getString(2));
				doanVien.setMaChucVu(rs.getString(3));
				doanVien.setTenDoanVien(rs.getString(4));
				doanVien.setNgaySinh(rs.getString(5));
				doanVien.setGioiTinh(rs.getString(6));
				doanVien.setDienThoai(rs.getString(7));
				doanVien.setTenChiDoan(rs.getString(8));
				doanVien.setTenChucVu(rs.getString(9));
				doanViens.add(doanVien);
			}
			// close connection
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return doanViens;
	}

	public static List<ChiDoan> layDanhSachChiDoan() {
		List<ChiDoan> chiDoans = new ArrayList<ChiDoan>();
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from CHI_DOAN");
			ChiDoan chiDoan = null;
			while (rs.next()) {
				chiDoan = new ChiDoan();
				chiDoan.setMaChiDoan(rs.getString(1));
				chiDoan.setMaKhoa(rs.getString(2));
				chiDoan.setTenChiDoan(rs.getString(3));
				chiDoan.setDienThoai(rs.getString(4));
				chiDoans.add(chiDoan);
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return chiDoans;
	}
	public static List<ChucVu> layDanhSachChucVu() {
		List<ChucVu> chucVus = new ArrayList<ChucVu>();
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from CHUC_VU");
			ChucVu chucVu = null;
			while (rs.next()) {
				chucVu = new ChucVu();
				chucVu.setMaChucVu(rs.getString(1));
				chucVu.setTenChucVu(rs.getString(2));
				chucVus.add(chucVu);
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return chucVus;
	}
	public static List<DoanPhi> layDanhSachDoanPhi() {
		List<DoanPhi> doanPhis = new ArrayList<DoanPhi>();
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from DOAN_PHI");
			DoanPhi doanPhi = null;
			while (rs.next()) {
				doanPhi = new DoanPhi();
				doanPhi.setMaPhieu(rs.getString(1));
				doanPhi.setMaDoanVien(rs.getString(2));
				doanPhi.setNgayNop(rs.getString(3));
				doanPhi.setLiDoNop(rs.getString(4));
				doanPhis.add(doanPhi);
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return doanPhis;
	}
	public static List<Khoa> layDanhSachKhoa() {
		List<Khoa> khoas = new ArrayList<Khoa>();
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from KHOAA");
			Khoa Khoa = null;
			while (rs.next()) {
				Khoa = new Khoa();
				Khoa.setMaKhoa(rs.getString(1));
				Khoa.setDienThoai(rs.getString(2));
				Khoa.setTenKhoa(rs.getString(3));
				khoas.add(Khoa);

			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return khoas;
	}

}
