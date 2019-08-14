package com.dream.dandroid;
import android.annotation.*;
import android.os.*;
import android.support.design.widget.*;
import android.support.v4.view.*;
import android.support.v7.app.*;
import android.view.*;
import com.dream.dandroid.utils.*;
import java.util.*;
import android.widget.LinearLayout;
import android.widget.Toast;
public class HomeActivity extends AppCompatActivity
{
	private ViewPager mViewPager;
    private MyPagerAdapter mMyPagerAdapter;
	private MenuItem menuItem;
	private BottomNavigationView bottomNavigationView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
		init();
	}

	private void init()
	{
		// TODO: Implement this method
		List<View> viewList = new ArrayList<View>();
        LayoutInflater layoutInflater = getLayoutInflater();
		View v = layoutInflater.inflate(R.layout.p_home,null);
		View v2 = layoutInflater.inflate(R.layout.p_code,null);
		View v3 = layoutInflater.inflate(R.layout.p_teach,null);
		viewList.add(v);
		viewList.add(v2);
		viewList.add(v3);
		mMyPagerAdapter = new MyPagerAdapter(viewList);
		mViewPager.setAdapter(mMyPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
		BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        events_for_home(v);
		mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
				@Override
				public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

				}

				@Override
				public void onPageSelected(int position) {
					if (menuItem != null) {
						menuItem.setChecked(false);
					} else {
						bottomNavigationView.getMenu().getItem(0).setChecked(false);
					}
					menuItem = bottomNavigationView.getMenu().getItem(position);
					menuItem.setChecked(true);
				}

				@Override
				public void onPageScrollStateChanged(int state) {
				}
			});
		mViewPager.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					return true;
				}
			});
		bottomNavigationView.setOnNavigationItemSelectedListener(
			new BottomNavigationView.OnNavigationItemSelectedListener() {
				@Override
				public boolean onNavigationItemSelected(@NonNull MenuItem item) {
					switch (item.getItemId()) {
							//这里是点击换页的
						case R.id.home_page:
							mViewPager.setCurrentItem(0);
							break;
						case R.id.code_page:
							mViewPager.setCurrentItem(1);
							break;
						case R.id.teach_page:
							mViewPager.setCurrentItem(2);
							break;
					}
					return false;
				}
			});
	}

    private void events_for_home(View v)
    {
        // TODO: Implement this method
        LinearLayout llt1 = v.findViewById(R.id.homes_aide_dl);
        llt1.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View p1)
                {
                    // TODO: Implement this method
                    Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                }
            });
    }
	
	class MyPagerAdapter extends PagerAdapter 
	{
		private List<View> mViewList;

		MyPagerAdapter(List<View> viewList) {
			mViewList = viewList;
		}

		@Override
		public int getCount() {
			//Log.i(TAG, NAME + "--getCount");
			return mViewList.size();
		}

		@Override
		public int getItemPosition(Object object) { 
			return super.getItemPosition(object);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			//Log.i(TAG, NAME + "--isViewFromObject");
			return view == mViewList.get((int)Integer.parseInt(object.toString()));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = mViewList.get(position);
			container.addView(view);
			//Log.i(TAG, NAME + "--instantiateItem++container:" + container.getChildCount() + "++position:" + position);
			return position;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(mViewList.get(position));
			//Log.i(TAG, NAME + "--destroyItem++container:" + container.getChildCount() + "++position:" + position);
		}
	}
}
