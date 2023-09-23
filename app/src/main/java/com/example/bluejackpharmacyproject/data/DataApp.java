package com.example.bluejackpharmacyproject.data;

import com.example.bluejackpharmacyproject.R;

import java.util.ArrayList;
import java.util.Objects;

public class DataApp {
    public static volatile DataApp INSTANCE = null;
    public DataApp() {}

    public static DataApp getInstance() {
        if(INSTANCE == null) {
         synchronized (DataApp.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataApp();
                }
            }
        }
        return INSTANCE;
    }
    public static int userIdNow;

    public static int getUserIdNow() {
        return userIdNow;
    }

    public void setUserIdNow(int userIdNow) {
        this.userIdNow = userIdNow;
    }

    public static ArrayList<MedicineData> MedData = new ArrayList<>();

    public static ArrayList<MedicineData> getMedData() {
        return MedData;
    }

    public void setMedData(ArrayList<MedicineData> medData) {
        MedData = medData;
    }

    public void addMed(MedicineData medData){
        this.MedData.add(medData);
    }


    public ArrayList<UserData> userList = new ArrayList<>();
    public ArrayList<UserData> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserData> userList) {
        this.userList = userList;
    }

    public void addUser(UserData userList){
        this.userList.add(userList);
    }


    public static ArrayList<TransactionData> transactionList = new ArrayList<>();
    public static ArrayList<TransactionData> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<TransactionData> transactionList) {
        this.transactionList = transactionList;
    }
    public void addTrans(TransactionData transactionList){
        this.transactionList.add(transactionList);
    }

    public static ArrayList<TransactionData> transactionListUser = new ArrayList<>();
    public static ArrayList<TransactionData> gettransactionListUser() {
        return transactionListUser;
    }

    public void settransactionListUser() {
        this.transactionListUser = transactionListUser;
    }
    public void addTransUser(TransactionData transactionListUser){
        this.transactionListUser.add(transactionListUser);
    }

    public void resetTransUser(){
        this.transactionListUser.clear();

    };

    public static void UpdateTrans(){
        gettransactionListUser().clear();
        for (TransactionData trans : transactionList){
            if (Objects.equals(trans.getUserId(), getUserIdNow())){
                gettransactionListUser().add(trans);
            }
        }
    };



//    isi data
    public void DataList(){
        this.userList.add(new UserData(
                0,
                "Vania P",
                "083819792550",
                "vaniaps02@gmail.com",
                "vania1234"
        ));

        this.userList.add(new UserData(
                1,
                "admin",
                "0811111111",
                "admin@gmail.com",
                "admin11"
        ));

        this.MedData.add(new MedicineData(
                0,
                R.drawable.iliadin,
                "Iliadin Nasal Spray",
                "Merck Indonesia",
                61300,
                "ILIADIN DEWASA 0.05% NASAL SPRAY 10 ML mengandung zat aktif Oxymetazoline." +
                        " Obat ini digunakan untuk meringankan hidung tersumbat dan nasofaring akibat flu, sinusitis," +
                        " hayfever atau alergi saluran pernapasan bagian atas. Bila digunakan untuk kerperluan swamedikasi, " +
                        "jangan digunakan selama lebih dari 7 hari berturut-turut."));

        this.MedData.add(new MedicineData(
                1,
                R.drawable.sanadryl,
                "Sanadryl Sirup",
                "Sanbe Farma",
                32400,
                "SANADRYL DMP SIRUP merupakan obat batuk tidak berdahak yang mengandung zat aktif Dextromethorphan HBr," +
                        " Difenhidramin HCl, Ammonium Klorida, Natrium Sitrat dan menthol. Sanadryl DMP digunakan untuk meringankan gejala batuk tidak berdahak yang menimbulkan rasa sakit atau batuk karena alergi. " +
                        "Dextromethorphan HBr sebagai antitusif yang bisa menekan refleks batuk. " +
                        "Difenhidramin HCl bekerja sebagai antihistamin/anti alergi untuk meredakan gejala alergi seperti bersin-bersin. " +
                        "Ammonium Klorida digunakan sebagai campuran dalam obat batuk yang memiliki efek sebagai pengencer dahak sehingga " +
                        "dapat meringankan gejala batuk tidak berdahak yang menimbulkan rasa sakit atau batuk karena alergi."
        ));

        this.MedData.add(new MedicineData(
                2,
                R.drawable.panadol,
                "Panadol Cold & Flu",
                "Sterling",
                11000,
                "PANADOL COLD & FLU merupakan obat batuk dan pereda flu dengan kandungan Paracetamol, Pseudoephedrine HCI, dan Dextromethorphan HBr." +
                        " Obat ini dapat digunakan untuk meredakan gejala flu seperti: demam, sakit kepala, hidung tersumbat dan batuk tidak berdahak."

        ));

        this.MedData.add(new MedicineData(
                3,
                R.drawable.longatine,
                "Longatin 50 mg",
                "Actavis",
                40000,
                "LONGATIN merupakan obat batuk dengan kandungan Noscapine." +
                        " Obat ini bersifat antitusif yaitu bekerja dengan cara menekan batuk secara sentral. " +
                        "Longatin digunakan untuk meredakan batuk yang tidak berdahak atau yang menimbulkan rasa sakit. " +
                        "Dalam menggunakan obat ini HARUS SESUAI DENGAN PETUNJUK DOKTER."

        ));

        this.MedData.add(new MedicineData(
                4,
                R.drawable.apolar,
                "Apolar 0.5 mg/g Cream",
                "Actavis",
                11000,
                "PANADOL COLD & FLU merupakan obat batuk dan pereda flu dengan kandungan Paracetamol, Pseudoephedrine HCI, dan Dextromethorphan HBr." +
                        " Obat ini dapat digunakan untuk meredakan gejala flu seperti: demam, sakit kepala, hidung tersumbat dan batuk tidak berdahak."

        ));

        this.MedData.add(new MedicineData(
                5,
                R.drawable.gratusif,
                "Grantusif",
                "Graha Farma",
                5000,
                "GRANTUSIF mengandung kombinasi obat Dextromethorphan HBr, Diphenhydramine, dan Guaifenesin." +
                        " Dextromethorphan HBr bekerja dengan cara menekan pusat rangsang batuk. " +
                        "Guaifenesin bekerja dengan cara menurunkan kekentalan dahak sehingga mempermudah pengeluaran dahak. " +
                        "Diphenhydramine HCl dapat meredakan batuk karena alergi. Obat ini digunakan untuk mengatasi batuk yang disertai alergi." +
                        "GRANTUSIF 10 KAPLET mengandung kombinasi obat Dextromethorphan HBr, Diphenhydramine, dan Guaifenesin. Dextromethorphan HBr bekerja dengan cara menekan pusat rangsang batuk. " +
                        "Guaifenesin bekerja dengan cara menurunkan kekentalan dahak sehingga mempermudah pengeluaran dahak." +
                        "Diphenhydramine HCl dapat meredakan batuk karena alergi. Obat ini digunakan untuk mengatasi batuk yang disertai alergi."
        ));
        this.MedData.add(new MedicineData(
                6,
                R.drawable.minosep,
                "Minosep Obat Kumur 0.2%",
                "Minorock Mandiri",
                43400,
                "MINOSEP OBAT KUMUR merupakan obat kumur yang mengandung zat aktif Chlorhexidine gluconate. " +
                        "Obat kumur ini digunakan sebagai perlindungan terhadap kuman, meringankan sariawan dan membantu memberi rasa segar pada mulut"
        ));
        this.MedData.add(new MedicineData(
                7,
                R.drawable.cefixime,
                "Cefixime 200 mg",
                "Generic Manufacturer",
                15000,
                "CEFIXIME 200 MG KAPSUL merupakakan obat generik yang mengandung Cefixime 200 mg per tablet. " +
                        "Cefixime adalah antibiotik golongan cephalosporin generasi ketiga. " +
                        "Cefixime merupakan antibiotik yang memiliki spektrum luas, aktif terhadap bakteri gram negatif mapun gram positif. " +
                        "Antibiotik ini digunakan untuk mengobati infeksi saluran kemih tanpa komplikasi, otitis media, faringiris dan tonsilitis, " +
                        "serta bronkitis akut dan kronis dengan eksaserbasi akut. " +
                        "Obat ini bekerja sebagai bakterisidal dengan mekanisme kerja obat dengan cara mengikat satu atau lebih penicillin-binding proteins (PBP) yang menghambat transpeptidasi tahap terakhir dari sintesis peptidoglikan di dinding sel bakteri, " +
                        "sehingga menghambat biosintesis dan mencegah pembentukan dinding sel yang mengakibatkan kematian sel bakteri. Dalam menggunakan obat ini HARUS SESUAI DENGAN PETUNJUK DOKTER."

        ));

        this.transactionList.add(new TransactionData(
             "12 Januari 2023",
             MedData.get(0),
              2,
                0
        ));

        this.transactionList.add(new TransactionData(
                "1 Februari 2023",
                MedData.get(3),
                4,
                0
        ));
        this.transactionList.add(new TransactionData(
                "10 Maret 2023",
                MedData.get(1),
                1,
                0
        ));

        this.transactionList.add(new TransactionData(
                " 20 Maret 2023",
                MedData.get(7),
                6,
                0
        ));

        this.transactionList.add(new TransactionData(
                "12 December 2022",
                MedData.get(2),
                2,
                1
        ));

        this.transactionList.add(new TransactionData(
                "10 Februari 2023",
                MedData.get(4),
                1,
                1
        ));






    }
}





