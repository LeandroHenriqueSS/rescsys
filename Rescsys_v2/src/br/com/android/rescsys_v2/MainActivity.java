package br.com.android.rescsys_v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.LauncherActivity.IconResizer;
import android.os.Bundle;
import android.renderscript.Font;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	private static int POS;
	
	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setIcon(getIconID(i))
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new DummySectionFragment();
            Bundle args = new Bundle();
            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
            fragment.setArguments(args);
            return fragment;
		}

		@Override
		public int getCount() {
			// Show 5 total pages.
			return 5;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			case 4:
				return getString(R.string.title_section5).toUpperCase(l);
			}

			return null;
		}
	}

	/**
     * A dummy fragment representing a section of the app, but that simply
     * displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public DummySectionFragment() {
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main_dummy, container, false);       

            TextView dummyTextView = (TextView) rootView
                  .findViewById(R.id.section_label);
            
            String sectionNumb = Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER));
            int cat1 = Integer.parseInt(sectionNumb);
            
            String saida = "aa";
            switch (cat1) {
            case 1:
            	saida = "Instruções Gerais\n\n" +
            		"\t• Mova-se para longe da costa. Utiliza a opção ROTA DE FUGA para consultar a rota de" +
            			"avacuação ideal\n\n" +
            		"\t• Caso não senha onde se abrigar, consete a opção ABRIGOS para encontrar os refúgios" +
            			"mais próximos\n\n" +
            		"\t• Caso necessário, utilize a opção HOSTIPAIS para obter uma lista de hospitais" +
            			"disponíveis\n\n" +
            		"\t• Consulte a opção ÁREA DE RISCO para saber quais áreia da região devem ser evitadas\n\n" +
            		"\t• Clique em INSTRUÇÔES no menu para retornar a esta tela\n";
                break;
            case 2:
            	saida = "Lista de abrigos disponíveis - João Pessoa\n\n" +
            			"\t• Ginásio Ronaldão - Cristo\n" +
            			"\t• 15º Batalhão de Infantaria Motorizada\n" +
            			"\t• IFPB - Jaguaribe\n";
                break;
            case 3:
            	saida = "Lista de Hospitais disponíveis - João Pessoa\n\n" +
            			"\t• Hospital Memorial São Francisco - Torre\n" +
            			"\t• Hospital Edson Ramalho - Centro\n" +
            			"\t• Hospital da Unimed - Torre\n";
                break;
            case 4:
            	saida = "Áreas de Risco - João Pessoa\n\n" +
            			"\t• Bessa\n" +
            			"\t• Manaíra\n" +
            			"\t• Tambaú\n" +
            			"\t• Cabo Branco\n" +
            			"\t• UFPB\n";
            	break;
            case 5:
            	saida = "Rota de Evacuação\n\n" +
            		"•  ↑ Siga pela via expressa\n" +
            		"• <- Entre à esquerda na Av. Dom Pedro II\n" +
            		"• <- Entre à esqueda na Av. Epitário Pessoa";
                break;
            }  
            dummyTextView.setText(saida);
            dummyTextView.setBottom(R.id.action_settings);
            return rootView;
        }
    
}
		 
		  /*
		   * Sets the on-click listener for the listviews when they are created.
		   * @param listview The listview you want to set
		   */
		  public void setListViewOnClickListner(final ListView listView)  {

			  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		        String item = ((TextView) view).getText().toString();
		        /*
		         * Functionality when pressing buttons would go here
		         */
		        Toast.makeText(listView.getContext(), item, Toast.LENGTH_LONG).show();
		      }
		    });
		  
		  
	}
	
	private int getIconID(int i) {
		switch(i) {
			case 0:
				i = R.drawable.instrucoes;
				break;
			case 1:
				i = R.drawable.abrigo;
				break;
			case 2:
				i = R.drawable.hospital_icon_1;
				break;
			case 3:
				i = R.drawable.fuga;
				break;
			case 4:
				i = R.drawable.risco;
				break;
		}
		
		return i;
	}
	
	

}
