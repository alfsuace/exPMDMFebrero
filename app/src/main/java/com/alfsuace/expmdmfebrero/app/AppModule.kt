package com.alfsuace.expmdmfebrero.app

import com.alfsuace.expmdmfebrero.data.local.AlbumMock
import com.google.gson.Gson
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.alfsuace.expmdmfebrero")
class AppModule {

    @Single
    fun provideGson():Gson{
        return Gson()
    }

    @Single
    fun provideMock():AlbumMock{
        return AlbumMock()
    }
}