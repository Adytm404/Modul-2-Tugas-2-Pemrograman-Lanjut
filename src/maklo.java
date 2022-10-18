package com.nyan.modul2.tugas2;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

public class maklo {

    public static String inName;
    public static String[][] book = {{"These Violent Delights", "Bundling Buku Shine dan Bright", "Bicara Itu Ada Seninya"}}; // dibaca belakang
    public static String[][] year = {{"2021"}, {"2019"}, {"2020"}}; // dibaca depan
    public static Scanner input = new Scanner(System.in);
    public static boolean loops = true;

    public static void main(String[] args) {
        try{
            menu();
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error Array!");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Error String!");
        }catch (InputMismatchException e){
            System.out.println("Error Input Menu!");
        }

    }

    static void menu(){

        System.out.println("Welcome to Liblary Menu \n 1. Search Book \n 2. List of Books \n 3. Exit menu \n");
        System.out.print("Pilih menu: ");

        try{
            int menu = input.nextInt();

            if(menu == 1){
                input();
            }else if(menu == 2){
                System.out.println("=== Index of File ===");
                list();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("=== End of File ===\n");
            menu();
        }

    }

    static void input(){
        do{
            try{
                do{
                    System.out.print("Input Nama: ");
                    input.nextLine();
                    inName = input.nextLine();
                }while(cekName(inName) == 200);
            }catch (ArrayIndexOutOfBoundsException e){

                System.out.println("Data belum tersedia!");

                cekFrom();

            }finally {
                System.out.print("Ingin kembali ke menu? Y/N: ");
                String end = input.next();
                if(end.toUpperCase().compareTo("N") == 0){
                    loops = false;
                }else if(end.toUpperCase().compareTo("Y") == 0){
                    menu();
                }
            }
        }while (loops);
    }

    static void list(){
        for(int i = 0; book[0][i] != null; i++){
            int jumlah = i+1;
            System.out.println(jumlah + ". " + book[0][i] + " (" + year[i][0] + ")");

        }
    }

    static void cekFrom(){
        System.out.print("Apakah anda ingin merubah data? Y/N: ");
        String tambah = input.next();
        switch (tambah){
            case "y":
                System.out.print("Pilih nomor data: ");
                int noData = input.nextInt();
                noData = noData-1;
                System.out.print("Input nama baru buku: ");
                input.nextLine();
                book[0][noData] = input.nextLine();
                System.out.print("Input tahun baru buku: ");
                year[noData][0] = input.next();
                int tempYear = Integer.parseInt(year[noData][0]);
                cekDate(tempYear);

                break;
            case "n":
                break;
        }
    }

    static void cekDate(int date){
        if(date < 2018 || date > 2022){
            System.out.println("Data berhasil ditambahkan!");
        }else {
            System.out.println("Tahun tidak valid!");
            cekFrom();
        }
    }


    static int cekName(String name) {
        for (int i = 0; book[0][i] != null; ++i) {
            if (book[0][i].compareTo(name) == 0) {
                System.out.println("Data sudah ada!");
                return 200;
                }
            }
            return 0;
        }
    }