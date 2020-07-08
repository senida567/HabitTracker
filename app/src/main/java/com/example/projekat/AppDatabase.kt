package com.example.projekat

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projekat.DAO.*
import com.example.projekat.entity.*
import com.example.projekat.service.*


@Database(entities = [Inkrementalne::class,
                        Kategorije::class,
                        Kolicinske::class,
                        MjerneJedinice::class,
                        Osobine::class,
                        Vremenske::class],
    version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    private var appDatabase: AppDatabase? = null

    private var inkrementalneService: InkrementalneService? = null
    abstract fun getInkrementalneDao(): InkrementalneDAO?

    private var kategorijeService: KategorijeService? = null
    abstract fun getKategorijeDao(): KategorijeDAO?

    private var kolicinskeService: KolicinskeService? = null
    abstract fun getKolicinskeDao(): KolicinskeDAO?

    private var mjerneJediniceService: MjerneJediniceService? = null
    abstract fun getMjerneJediniceDao(): MjerneJediniceDAO?

    private var osobineService: OsobineService? = null
    abstract fun getOsobineDao(): OsobineDAO?

    private var vremenskeService: VremenskeService? = null
    abstract fun getVremenskeDao(): VremenskeDAO?


    open fun buildDatabaseInstance(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java,
            java.lang.String.valueOf(R.string.db_name)
        ).allowMainThreadQueries().build()
    }

    open fun setService(serviceName: String): AppDatabase? {
        if (serviceName == java.lang.String.valueOf(R.string.inkrementalne_service)) {
            appDatabase!!.setInkrementalneService(InkrementalneService(appDatabase!!.getInkrementalneDao()))
        } else if (serviceName == java.lang.String.valueOf(R.string.kategorije_service)) {
            appDatabase!!.setKategorijeService(KategorijeService(appDatabase!!.getKategorijeDao()))
        } else if (serviceName == java.lang.String.valueOf(R.string.kolicinske_service)) {
            appDatabase!!.setKolicinskeService(KolicinskeService(appDatabase!!.getKolicinskeDao()))
        } else if (serviceName == java.lang.String.valueOf(R.string.mjerne_jedinice_service)) {
            appDatabase!!.setMjerneJediniceService(MjerneJediniceService(appDatabase!!.getMjerneJediniceDao()))
        } else if (serviceName == java.lang.String.valueOf(R.string.osobine_service)) {
            appDatabase!!.setOsobineService(OsobineService(appDatabase!!.getOsobineDao()))
        } else if (serviceName == java.lang.String.valueOf(R.string.vremenske_service)) {
            appDatabase!!.setVremenskeService(VremenskeService(appDatabase!!.getVremenskeDao()))
        }
        // ovdje idu ostali servisi ako ih ima
        return appDatabase
    }

    open fun setAllServices(): AppDatabase {

        appDatabase!!.setInkrementalneService(InkrementalneService(appDatabase!!.getInkrementalneDao()))
        appDatabase!!.setKategorijeService(KategorijeService(appDatabase!!.getKategorijeDao()))
        appDatabase!!.setKolicinskeService(KolicinskeService(appDatabase!!.getKolicinskeDao()))
        appDatabase!!.setMjerneJediniceService(MjerneJediniceService(appDatabase!!.getMjerneJediniceDao()))
        appDatabase!!.setOsobineService(OsobineService(appDatabase!!.getOsobineDao()))
        appDatabase!!.setVremenskeService(VremenskeService(appDatabase!!.getVremenskeDao()))
        return appDatabase as AppDatabase
    }

    open fun getInstanceByContextAndService(context: Context, serviceName: String): AppDatabase {
        if (appDatabase == null) {
            appDatabase = buildDatabaseInstance(context)
        }
        appDatabase = if (serviceName == java.lang.String.valueOf(R.string.all_services)) {
            setAllServices()
        } else {
            setService(serviceName)
        }
        return appDatabase as AppDatabase
    }


    open suspend fun cleanDatabase(context: Context) {
        if (appDatabase == null) {
            appDatabase = buildDatabaseInstance(context)
        }
        setAllServices()
        appDatabase!!.inkrementalneService?.deleteAll()
        appDatabase!!.kategorijeService?.deleteAll()
        appDatabase!!.kolicinskeService?.deleteAll()
        appDatabase!!.mjerneJediniceService?.deleteAll()
        appDatabase!!.osobineService?.deleteAll()
        appDatabase!!.vremenskeService?.deleteAll()
    }


    open fun setInkrementalneService(inkrementalneService: InkrementalneService) {
        this.inkrementalneService = inkrementalneService
    }
    open fun setKategorijeService(kategorijeService: KategorijeService) {
        this.kategorijeService = kategorijeService
    }
    open fun setKolicinskeService(kolicinskeService: KolicinskeService) {
        this.kolicinskeService = kolicinskeService
    }
    open fun setMjerneJediniceService(mjerneJediniceService: MjerneJediniceService) {
        this.mjerneJediniceService = mjerneJediniceService
    }
    open fun setOsobineService(osobineService: OsobineService) {
        this.osobineService = osobineService
    }
    open fun setVremenskeService(vremenskeService: VremenskeService) {
        this.vremenskeService = vremenskeService
    }

    open fun getKategorijeService(): KategorijeService? { return kategorijeService }
    open fun getOsobineService() : OsobineService? { return osobineService }
    open fun getKolicinskeService() : KolicinskeService? { return kolicinskeService }
    open fun getVremenskeService() : VremenskeService? { return vremenskeService }
    open fun getInkrementalneService() : InkrementalneService? {return inkrementalneService }
    open fun getMjerneJediniceService() : MjerneJediniceService? { return mjerneJediniceService }
}