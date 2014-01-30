package br.gextract.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.gextract.domain.Place;
import br.gextract.util.SQLiteHelper;

public class PlaceDAO {
	private static String TABLE_NAME = "place";
	private static String COLUMN_ID = "place_id";
	private static String COLUMN_STREET = "place_street";
	private static String COLUMN_CITY = "place_city";

	private Connection conn;
	private Statement stm;

	private static String initTableCommand() {
		StringBuffer sb = new StringBuffer();
		sb.append("create table ");
		sb.append(TABLE_NAME);
		sb.append("(");
		sb.append(COLUMN_ID);
		sb.append(" integer primary key autoincrement,");
		sb.append(COLUMN_STREET);
		sb.append(" varchar not null,");
		sb.append(COLUMN_CITY);
		sb.append(" varchar not null);");

		return sb.toString();
	}

	private static String insertCommand(Place place) {
		StringBuffer sb = new StringBuffer("");

		if (place != null) {
			sb.append("INSERT INTO ");
			sb.append(TABLE_NAME);
			sb.append("(");
			sb.append(COLUMN_STREET);
			sb.append(", ");
			sb.append(COLUMN_CITY);
			sb.append(") VALUES ('");
			sb.append(place.street);
			sb.append("', '");
			sb.append(place.city);
			sb.append("');");
		}

		return sb.toString();
	}

	public PlaceDAO(boolean initTable, boolean closeConnection)
			throws ClassNotFoundException, SQLException {
		// Abre a conexão
		this.conn = SQLiteHelper.createConnection();

		// Executa o comando
		this.stm = this.conn.createStatement();
		this.stm.executeUpdate("DROP TABLE IF EXISTS " + TABLE_NAME);
		this.stm.executeUpdate(initTableCommand());
		SQLiteHelper.closeStatement(this.stm);

		// Fecha a conexão
		if (closeConnection) {
			SQLiteHelper.closeConnection(this.conn);
		}
	}

	public void insert(Place place, boolean closeConnection)
			throws SQLException, ClassNotFoundException {
		// Abre a conexão
		if (this.conn == null || (this.conn != null && this.conn.isClosed())) {
			this.conn = SQLiteHelper.createConnection();
		}

		// Executa o comando
		this.stm = this.conn.createStatement();
		this.stm.executeUpdate(insertCommand(place));
		SQLiteHelper.closeStatement(this.stm);

		// Fecha a conexão
		if (closeConnection) {
			SQLiteHelper.closeConnection(this.conn);
		}
	}
}