package cr.informatech.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Parse.initialize(this, "application_key", "client_key"); 
		
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addTodo(View view) {
		EditText editText = (EditText) findViewById(R.id.editText1);
		String message = editText.getText().toString();
		
		ParseObject todo = new ParseObject("TodoObject");
		todo.put("todo", message);
		todo.saveInBackground();
		
		editText.setText("");
	}

}
