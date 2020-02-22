/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsm.exampleRefactor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author eduar
 */

public class Example {

	public String s = null;
	private Object declaredITDFields;

	public void testTryWithResources21() throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader(
				"journaldev.txt"));
		String a = "";
		String b = a;
		try {
			reader1.readLine();
			String c = "";
			c.equals(b);
		} catch (IOException e) {
			System.out.println("Erro");
		}

	}

	public void testTryWithResources() throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader(
				"journaldev.txt"));
		try (BufferedReader reader2 = reader1) {
			reader2.readLine();
		} catch (IOException e) {
			System.out.println("Erro");
		}
	}

	public void testTryWithResources2() throws IOException {
		BufferedReader readerNO = new BufferedReader(new FileReader(
				"journaldev.txt"));
		List<InterTypeFieldDeclaration> itdfs = new ArrayList<InterTypeFieldDeclaration>();
		BufferedReader reader1 = new BufferedReader(new FileReader(
				"journaldev.txt"));

		if (this.declaredITDFields == null) {
			Method[] baseMethods = clazz.getDeclaredMethods();
			for (Method m : baseMethods) {
				if (m != null) {
					if (!m.getName().contains("ajc$interFieldInit"))
						continue;
					String interFieldInitMethodName = m.getName();
					String interFieldGetDispatchMethodName = interFieldInitMethodName
							.replace("FieldInit", "FieldGetDispatch");
					try {
						readerNO.readLine();
						Method dispatch = clazz.getDeclaredMethod(
								interFieldGetDispatchMethodName,
								m.getParameterTypes());
					} catch (IOException e) {
						System.out.println("Erro");
					}
				}
			}
		}
	}

	public void stripLeading() {
		String s = " a ";
		String ltrim = s.replaceAll("^\\s+", "");
		String rtrim = s.replaceAll("\\s+$", "");
	}

	public void patternMatching(Object obj) {
		if (obj instanceof String) {
			int a = 0;
			String b = (String) obj;
		} else {
		}
	}

	public void patternMatching2(Object obj) {
		if (obj != null && obj instanceof String) {
			int a = 0;
			String b = (String) obj;
		} else {
		}
	}

	public void patternMatching3(Object obj) {
		if (obj instanceof String && obj != null) {
			int a = 0;
			String b = (String) obj;
		} else {
		}
	}

	public void patternMatching4(Object obj) {
		if (obj == null && obj instanceof String || obj != null) {
			int a = 0;
			String b = (String) obj;
		} else {
		}
	}

	public void patternMatching5(Object obj) {
		if (obj instanceof String || obj == null && obj != null) {
			int a = 0;
			String b = (String) obj;
		} else {
		}
	}

	public void patternMatching6(Object obj) {
		if (obj == null && obj != null || obj instanceof String) {
			int a = 0;
			String b = (String) obj;
		} else {
		}
	}

	public void exempleStream() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Aman");
		// create a stream with ArrayList
		Stream<ArrayList<String>> value = Stream.of(list);

		final List<String> stringList = new ArrayList<>();

		stringList.add("Brasil");

		List<String> brasilList = stringList.stream()
				.filter(s -> s.equals("Brasil")).collect(Collectors.toList());

		stringList.stream().flatMap(s -> {
			String temp = brasilList.get(0);
			return temp != null ? Stream.of(temp) : Stream.empty();
		}).collect(Collectors.toList());
	}

	public void exempleIf() {
		if (s != null) {
			System.out.println(s);
		} else {
			System.out.println("No Value");
		}
	}

	public void exempleIf2() {
		if (null != s) {
			System.out.println(s);
		} else {
			System.out.println("No Value");
		}
	}

	public void exempleIf4() {
		Optional<String> str = Optional.of("java2s.com");
		str.ifPresent(value -> System.out.println("Optional contains " + value));
	}

	public void testeLambda() {
		Runnable r = () -> System.out.println("Thread com função lambda!");
		new Thread(r).start();
		r = null;

		System.out.println("Imprime todos os elementos da lista!");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.forEach(n -> System.out.println(n));

	}

	public void exempleSwitch(String day, String day2) {
		switch (day) {
		case "MONDAY":
		case "TUESDAY":
		case "WEDNESDAY":
			System.out.println("Work a lot");
			break;
		case "THURSDAY":
		case "FRIDAY":
			System.out.println("work slower");
			break;
		case "SUNDAY":
		case "SATURDAY":
			System.out.println("weekend");
			break;
		}
	}

	public void verificaStringEmBranco2(String a, List s) {
		if (a.isEmpty() || a.trim().isEmpty()) {
			System.out.println("String está em branco");
		} else {
			System.out.println(a);
		}

		if (a.trim().length() == 0) {
			System.out.println("String está em branco");
		}

		if (s.toArray().length == 0) {

		}

	}

	public void loadDataFromDB() throws SQLException {
		Connection dbCon = DriverManager.getConnection("url", "user",
				"password");
		try (ResultSet rs = dbCon.createStatement().executeQuery(
				"select * from emp")) {
			while (rs.next()) {
				System.out.println("In loadDataFromDB() =====>>>>>>>>>>>> "
						+ rs.getString(1));
			}
		} catch (SQLException e) {
			System.out
					.println("Exception occurs while reading the data from DB ->"
							+ e.getMessage());
		} finally {
			if (null != dbCon)
				dbCon.close();
		}
	}

	public void printStringWithoutWhiteSpace(String string) {
		String text = "	There are a big text here			";
		System.out.print(text.trim());
	}

	public void testee() {
		List<String> list = Arrays.asList("Doc", "Grumpy", "Happy", "Sleepy",
				"Dopey", "Bashful", "Sneezy");

		System.out.println("List to Array example in Java 8:");

		Object[] objects = list.toArray();
		System.out.println(Arrays.toString(objects));
	}

	public void listToArray() {
		List<String> list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");

		String[] strings = null;
		// list.toArray(new String[list.size()]);
	}

	public void testVarFor(String[] array) throws IOException {
		for (int i = 0; i < array.length; i++) {
			// faz algo
		}

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		URL url = new URL(
				"https://www.ufsm.br/cursos/pos-graduacao/santa-maria/ppgcc/");
		URLConnection con = url.openConnection();
		Reader reader = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
	}

}
