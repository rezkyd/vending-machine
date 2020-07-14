# vending-machine
Simple Console Based Vending Machine for Testing

Program berbasis Java ini mensimulasikan proses jalannya Vending Machine sesuai dengan fungsi yang diminta.

Buatlah Object Oriented Program yang dapat menjalankan fungsi-fungsi sbb:
1. Terdapat 1 buah mesin vending machine
2. Pada mesin tersebut tersedia 5 buah jenis makanan: Biskuit, Chips, Oreo, Tango, Cokelat
3. Price list untuk tiap item sbb:
   1)  Biskuit: 6000
   2)  Chips: 8000
   3)  Oreo: 10000
   4)  Tango: 12000
   5)  Cokelat: 15000
4. Vending machine dapat menerima uang dengan pecahan : 2000, 5000, 10000, 20000, 50000.
5. Vending Machine dapat melakukan pembelian, pengembalian uang dan mendeteksi jika ada makanan yang stok-nya sedang habis.

Karena tidak ada spesifikasi yang khusus untuk framework dan cara penggunaannya, program ini berbasis Console yang menerima masukan dari pengguna dan hanya menggunakan library standar Java.
# Explanation
Program ini menerima 3 jenis masukan

1. Pilihan menu
   1. List Item: Menampilkan status makanan yang ada di Vending Machine
   2. Buy Item: Mulai membeli makanan, lanjut ke pilihan uang
   3. Turn Off: Mematikan Vending Machine dan menampilkan total uang yang didapatkan
2. Pilihan Uang
   - Pengguna memasukkan masing-masing lembar uang kedalam Vending machine
   - Jika valid akan masuk kedalam saldo aktif
   - Jika tidak valid akan muncul pesan error
   - Masukkan 0 untuk berhenti memasukkan uang dan lanjut ke pilihan item
3. Pilihan Item
   - Pengguna memilih nomor makanan yang ingin dibeli
   - Makanan yang tampil hanya yang harganya kurang dari saldo dan stok tersedia 
   - Masukkan 0 untuk berhenti memasukkan uang dan keluarkan makanan.

Ketika selesai, program menampilkan makanan yang dibeli, total harga, dan total kembalian. Kemudian kembali ke pilihan menu

# How to run
Clone Repository ini, compile dan jalankan `Main.java`



Secara default ketika pertama kali dijalankan akan masuk mode `Console`, dimana jalannya program tergantung pada masukan dari pengguna. 

Mode lainnya adalah `Test` dimana masukan pengguna dapat ditentukan dari awal sehingga program berjalan sampai akhir tanpa menunggu masukan. Tambahkan argumen `test` ketika menjalankan program atau ubah langsung pada `Main.java` untuk menggunakan mode `Test`.

         TestView testView = new TestView();
         testView.addMenuChoice(1);
         testView.addMenuChoice(2);
         // Money choice must end at 0
         testView.addMoneyChoice(new Integer[]{2000, 2050, 5000, 4000, 0});
         // Item choice must end at 0
         testView.addItemChoice(new Integer[]{1, 2, 3, 0});
         // Menu choice must end at 3
         testView.addMenuChoice(3);

         viewMode = testView;

# Modify Item
Berikut merupakan makanan yang secara default ada dalam program Vending Machine, terdiri dari atribut id, nama, harga, dan stok. Modifikasi kode ini jika ingin merubah status makanan yang ada di Vending Machine.

         List<Item> items = new ArrayList<>();
         items.add(new Item(1, "Biskuit", 6000, 10));
         items.add(new Item(2, "Chips", 8000, 10));
         items.add(new Item(3, "Oreo", 10000, 10));
         items.add(new Item(4, "Tango", 12000, 10));
         items.add(new Item(5, "Cokelat", 15000, 10));

