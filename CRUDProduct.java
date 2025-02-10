package com.juaracoding;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

class produk{
    String namaProduk;
    String kategori;
    double harga;
    int stok;


    public produk(String namaProduk, String kategori, double harga, int stok){
        this.namaProduk = namaProduk;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    @Override
    public String toString(){
        return "Nama Produk : " + namaProduk + " || Kategori : " + kategori + " || Harga Produk : " + harga + " || Stok : " + stok;
    }
}

public class CRUDProduct {
    static ArrayList<produk> listProduk = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("\t----Menu---\t\t");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Lihat Produk");
            System.out.println("3. Update Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Cari Produk");
            System.out.println("6. Urutkan Produk");
            System.out.println("7. Exit");
            System.out.print("Masukkan Pilihan = ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch(pilih){
                case 1:
                    tambahProduk();
                    break;
                case 2:
                    lihatProduk();
                    break;
                case 3:
                    updateProduk();
                    break;
                case 4:
                    hapusProduk();
                    break;
                case 5:
                    cariProduk();
                    break;
                case 6:
                    urutProduk();
                    break;
                case 7:
                    System.out.println("Thanks for come to our Apps");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    private static void tambahProduk(){
        System.out.print("Masukkan nama produk = ");
        String namaProduk = scanner.nextLine();

        System.out.print("Kategori (Fashion/Makanan/Elektronik/Perawatan/Dll) = ");
        String kategori = scanner.nextLine();

        double harga = -1;
        while (harga < 0){
            System.out.println("Harga tidak boleh dibawah NOL!");
            System.out.print("Harga Item = ");
            harga = scanner.nextDouble();
            if(harga < 0){
                System.out.println("Harga Tidak Valid!");
            }

        }
        int stok = -1;
        while (stok < 0) {
            System.out.print("Stok Item = ");
            stok = scanner.nextInt();
            if(stok < 0){
                System.out.println("Input Tidak Valid!");
        }
    }
        produk produk = new produk(namaProduk,kategori,harga,stok);
        listProduk.add(produk);
        System.out.println("Produk berhasil ditambah!!");
    }

    private static void lihatProduk(){
        if(listProduk.isEmpty()){
            System.out.println("Produk masih kosong!");
        }
        else{
            System.out.println("Daftar Produk : ");
            for(produk produk : listProduk){
                System.out.println(produk);
            }
        }
    }

    private static void updateProduk(){
        System.out.print("Masukkan Produk yang ingin diUpdate :");
        String barang = scanner.nextLine();

        produk produk = cariNamaProduk(barang);
        if(produk != null){
            System.out.print("Masukkan Update Harga Produk : ");
            produk.harga = scanner.nextDouble();

            System.out.print("Masukka Update Stok Produk : ");
            produk.stok = scanner.nextInt();
        }
        else{
            System.out.println("Produk Tidak diTemukan!");
        }

    }
    private static void hapusProduk(){
        System.out.print("Nama produk yang ingin di hapus :");
        String nama = scanner.nextLine();

        produk produk = cariNamaProduk(nama);
        if(produk != null){
            listProduk.remove(produk);
            System.out.println("Produk Sudah diDelete!");
        } else{
            System.out.println("Produk Not Found!");
        }

    }
    private static void cariProduk(){
        System.out.print("Masukkan Nama Produk atau Kategori = ");
        String keyword = scanner.nextLine();
        boolean ketemu = false;

        for(produk i : listProduk){
            if(i.namaProduk.equalsIgnoreCase(keyword)||i.kategori.equalsIgnoreCase(keyword)){
                System.out.println(i);
                ketemu = true;
            }
            if(!ketemu){
                System.out.println("Produk Tidak Ditemukan!");
            }
        }
    }
    private static void urutProduk(){

    }
    private static produk cariNamaProduk(String nama){
        for(produk i : listProduk){
            if(i.namaProduk.equalsIgnoreCase(nama)){
                return i;
            }
        }
        return null;
    }
}


