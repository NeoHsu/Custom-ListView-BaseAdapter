package tw.neohsu.android.activities;

import java.util.ArrayList;
import java.util.List;

import tw.neohsu.android.R;
import tw.neohsu.android.adapters.CustomBaseAdapter;
import tw.neohsu.android.model.RowItem;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static final String[] titles = new String[] { "BlackBerry Z10", "BlackBerry Q10", "BlackBerry Q5",
	        "BlackBerry Z30" };
	public static final String[] descriptions = new String[] { "OS : BlackBerry 10", "OS : BlackBerry 10",
	        "OS : BlackBerry 10", "OS : BlackBerry 10" };
	public static final Integer[] images = { R.drawable.z10, R.drawable.q10, R.drawable.q5, R.drawable.z30 };
	ListView listView;
	List<RowItem> rowItems;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rowItems = new ArrayList<RowItem>();
		int count = 0;
		while(count < 10){
			for(int i = 0;i < titles.length;i++){
				RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
				rowItems.add(item);
			}
			count++;
		}
	}
	
	protected void onResume() {
		super.onResume();
		if(listView == null){
			listView = (ListView) findViewById(R.id.list);
			listView.setEmptyView(findViewById(android.R.id.empty));
		}
		if(rowItems != null){
			CustomBaseAdapter adapter = new CustomBaseAdapter(this, rowItems);
			listView.setAdapter(adapter);
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					// TODO Auto-generated method stub
					Toast toast = Toast.makeText(getApplicationContext(),
					        "Item " + (position + 1) + ": " + rowItems.get(position), Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
					toast.show();
				}
			});
		}
		
	}
}
