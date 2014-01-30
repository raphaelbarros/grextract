package br.gextract.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteHelper {

	/**
	 * Método que cria uma conexão com uma base de dados sqlite
	 * 
	 * @return Conexão criada com a base de dados sqlite
	 * @throws SQLException Caso haja uma falha no estabelecimento da comunicação
	 * @throws ClassNotFoundException Caso o arquivo da base de dados não tenha sido encontrado
	 */
	public static Connection createConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		return DriverManager.getConnection("jdbc:sqlite:grextract.db");
	}

	/**
	 * Método que fecha um comando
	 * 
	 * @param stm comando a ser fechado
	 * @throws SQLException Caso ocorra um erro na execução da operação
	 */
	public static void closeStatement(Statement stm) throws SQLException {
		if (stm != null && !stm.isClosed()) {
			stm.close();
		}
	}
	
	/**
	 * Método que fecha uma conexão
	 * 
	 * @param conn conexão a ser fechada
	 * @throws SQLException Caso ocorra um erro na execução da operação
	 */
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
}
