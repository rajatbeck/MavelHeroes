package com.android.marvelApp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.android.marvelApp.R
import com.android.marvelApp.data.repository.Repository
import com.android.marvelApp.ui.character.CharacterListFragment
import com.android.marvelApp.utils.extensions.transact
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


public class MainActivity : DaggerAppCompatActivity()
//        HasSupportFragmentInjector
{


//    @Inject
//    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
//
//    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
//        return dispatchingAndroidInjector
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        transact{
//            add(R.id.fragmentContainer,CharacterListFragment.getInstance());
//        }

//        supportFragmentManager.beginTransaction()
//                .add(R.id.fragmentContainer, CharacterListFragment.getInstance(), CharacterListFragment::class.java.canonicalName)
//                .addToBackStack(null)
//                .commit()
    }
}
