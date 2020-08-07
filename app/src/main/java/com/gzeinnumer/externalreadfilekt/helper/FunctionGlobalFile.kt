package com.gzeinnumer.externalreadfilekt.helper

import java.io.*
import java.util.*


object FunctionGlobalFile {
    private const val TAG = "FunctionGLobalFile_"

    //create file
    fun initFile(text: String): Boolean {
        val file = File(FunctionGlobalDir.getStorageCard + FunctionGlobalDir.appFolder + "/File.txt")
        return try {
            val f = FileOutputStream(file)
            val writer = PrintWriter(f)
            writer.println(text + "1")
            writer.println(text + "2")
            writer.println(text + "3")
            writer.flush()
            writer.close()
            f.close()
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    fun readFile(path: String?): List<String>? {
        if (!FunctionGlobalDir.isFileExists(path!!)) {
            if (!initFile("Buat file")) {
                FunctionGlobalDir.myLogD(TAG, "File success dibuat")
            } else {
                return null
            }
        }
        val file = File(FunctionGlobalDir.getStorageCard + FunctionGlobalDir.appFolder + "/File.txt")
        val input: Scanner
        val list: MutableList<String> = ArrayList()
        input = try {
            Scanner(file)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            FunctionGlobalDir.myLogD(TAG, e.message!!)
            return list
        }
        while (input.hasNextLine()) {
            list.add(input.nextLine())
        }
        return list
    }
}
