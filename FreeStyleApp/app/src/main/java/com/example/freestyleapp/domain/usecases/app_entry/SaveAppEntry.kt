package com.example.freestyleapp.domain.usecases.app_entry

import com.example.freestyleapp.domain.manager.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}