package ui;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Libro;
import datos.BBDD;
import dao.DAOLibro;

public class Principal {
	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		
		BBDD.init();
		boolean continuar = true;
		while(continuar){
			imprimirMenu();
			System.out.println("\nIntroduce una de las opciones presentadas");
			String s = read.nextLine();
			s = s.trim(); //Elimina espacios del principio y final de la cadena
			if(s.length() > 0){
				char opcion = s.charAt(0);
				switch(opcion){
				case '1':
					altaLibro();
					break;
				case '2':
					eliminarLibro();
					break;		
				case '3':
					buscarLibro();
					break;
				case '4':
					listaLibros();
					break;
				case '5':
					System.out.println("Adi�s. Gracias por utilizar nuestra biblioteca virtual");
					continuar = false;
					break;
				default:
					System.out.println("Introduzca una opci�n v�lida entre las presentadas en el men�");
				}
			}
		}

		
	}

	private static void imprimirMenu(){
		System.out.println("\n==========BIBLIOTECA VITUAL===========");
		System.out.println("\t1.- Alta de libro");
		System.out.println("\t2.- Eliminaci�n de libro");
		System.out.println("\t3.- B�squeda de libros");	
		System.out.println("\t4.- Lista de libros en la Biblioteca Virtual");
		System.out.println("\t5.- Salir");
	}
	
	private static void altaLibro(){
		System.out.print("ISBN: ");
		int isbn = read.nextInt();
		read.nextLine();
		System.out.print("T�tulo: ");
		String titulo = read.nextLine();
		System.out.print("Autor: ");
		String autor = read.nextLine();
		System.out.print("N�mero de p�ginas: ");
		int paginas = read.nextInt();
		read.nextLine();
		
		Libro p = new Libro(isbn, titulo, autor, paginas);
		DAOLibro dao = new DAOLibro();
	
		if(!dao.create(p)){
			System.out.println("Fallo en la inserci�n."
					+ " �Este ISBN se encuentra ya en nuestra biblioteca?");
		}else{
			System.out.println("Se ha insertado con �xito el libro en la Base de Datos");
		}
	}
	
	private static void buscarLibro(){
		System.out.print("T�tulo: ");
		String titulo = read.nextLine();
		DAOLibro dao = new DAOLibro();
		ArrayList<Libro> libros = dao.read(titulo);
		if(libros == null){
			System.out.println("El T�tulo introducido no consta en la base de datos.");
		}else{
			for(Libro l: libros){
				System.out.println("\n");
				System.out.println(l);
			}
		}
	}
	
	private static void eliminarLibro(){
		System.out.print("ISBN del libro a borrar: ");
		int isbn = read.nextInt();
		read.nextLine();

		DAOLibro dao = new DAOLibro();
		
		Libro p = new Libro(isbn, null, null, 0);
		int c = dao.delete(p);
		
		switch (c){
		case 0:
			System.out.println("Se ha eliminado el libro con ISBN: " + isbn + " con �xito");
			break;
		case 1:
			System.out.println("No hay libro con ISBN " + isbn + " en nuestra base de datos");
			break;
		case 2:
			System.out.println("Fallo en la conexi�n a la Base de Datos de la biblioteca");
			break;		
		}	
	}
	private static void listaLibros(){
		System.out.println("\n\t======LISTADO DE TODOS LOS LIBROS EN LA BIBLIOTECA=====");
		
		DAOLibro dao = new DAOLibro();
		ArrayList<Libro> libros = dao.lista();
		
		for(Libro l: libros){
			System.out.println("\n");
			System.out.println(l);
		}
	}
}
