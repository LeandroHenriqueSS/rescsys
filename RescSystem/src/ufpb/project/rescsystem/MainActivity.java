package ufpb.project.rescsystem;

import ufpb.project.rescsystem.fragments.*;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.*;
import com.actionbarsherlock.app.ActionBar.*;
import com.actionbarsherlock.view.Menu;

public class MainActivity extends SherlockFragmentActivity implements
		TabListener {

	/* Fragments */
	private Instruction f1;
	private Shelter f2;
	private Hospital f3;
	private RiskAreas f4;
	private EscapeRoute f5;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTheme(R.style.Theme_Sherlock_Light);
		setContentView(R.layout.activity_exemplo_sherlock);

		f1 = (Instruction) getSupportFragmentManager().findFragmentById(
				R.id.fragmento1);
		f2 = (Shelter) getSupportFragmentManager().findFragmentById(
				R.id.fragmento2);
		f3 = (Hospital) getSupportFragmentManager().findFragmentById(
				R.id.fragmento3);
		f4 = (RiskAreas) getSupportFragmentManager().findFragmentById(
				R.id.fragmento4);
		f5 = (EscapeRoute) getSupportFragmentManager().findFragmentById(
				R.id.fragmento5);

		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab aba1 = getSupportActionBar().newTab().setText("Instru��es")
				.setTabListener(this).setIcon(R.drawable.instructions);
		
		Tab aba2 = getSupportActionBar().newTab().setText("Abrigos")
				.setTabListener(this).setIcon(R.drawable.shelters);

		Tab aba3 = getSupportActionBar().newTab().setText("Hospitais")
				.setTabListener(this).setIcon(R.drawable.hospitals);
		
		Tab aba4 = getSupportActionBar().newTab().setText("A. Risco")
				.setTabListener(this).setIcon(R.drawable.escape_route);
		
		Tab aba5 = getSupportActionBar().newTab().setText("Fuga")
				.setTabListener(this).setIcon(R.drawable.risc_areas);
		
		getSupportActionBar().addTab(aba1);
		getSupportActionBar().addTab(aba2);
		getSupportActionBar().addTab(aba3);
		getSupportActionBar().addTab(aba4);
		getSupportActionBar().addTab(aba5);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater()
				.inflate(R.menu.activity_exemplo_sherlock, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		if (tab.getPosition() == 0) {
			ft.show(f1).hide(f2).hide(f3).hide(f4).hide(f5);
		}else if(tab.getPosition() == 1){
			ft.hide(f1).show(f2).hide(f3).hide(f4).hide(f5);
		} else if(tab.getPosition() == 2){
			ft.hide(f1).hide(f2).show(f3).hide(f4).hide(f5);
		} else if(tab.getPosition() == 3){
			ft.hide(f1).hide(f2).hide(f3).show(f4).hide(f5);
		} else {
			ft.hide(f1).hide(f2).hide(f3).hide(f4).show(f5);
		} 
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

}