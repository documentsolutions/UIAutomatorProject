package br.edu.poli.aplicationtest;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtPhone;
    private ListView lvContacts;
    private ArrayAdapter<String> adapterContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edtName = (EditText) findViewById(R.id.edt_name);
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        lvContacts = (ListView) findViewById(R.id.lv_contacts);

        adapterContacts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvContacts.setAdapter(adapterContacts);
        lvContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String item = adapterContacts.getItem(position);
                adapterContacts.remove(item);
                return true;
            }
        });
    }

    public void add(View view) {
        String name = edtName.getText().toString();
        String phone = edtPhone.getText().toString();

        if(!validate(name, phone)){
            // TODO exibir alert inválido
            return;
        }

        adapterContacts.add(name + " - " + phone);
    }

    private boolean validate(String name, String phone) {
        // TODO
        return true;
    }
}
