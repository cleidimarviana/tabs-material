/*
*   The MIT License (MIT)
*
*   Copyright (c) 2015 Cleidimar Viana
*
*   Permission is hereby granted, free of charge, to any person obtaining a copy
*   of this software and associated documentation files (the "Software"), to deal
*   in the Software without restriction, including without limitation the rights
*   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*   copies of the Software, and to permit persons to whom the Software is
*   furnished to do so, subject to the following conditions:
*   The above copyright notice and this permission notice shall be included in all
*   copies or substantial portions of the Software.
*   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
*   SOFTWARE.
*/
package com.seamusdawkins.tablayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.seamusdawkins.tablayout.activities.CustomIconTextActivity;
import com.seamusdawkins.tablayout.activities.OnlyIconsActivity;
import com.seamusdawkins.tablayout.activities.ScrollableActivity;
import com.seamusdawkins.tablayout.activities.SimpleActivity;

public class MainActivity extends AppCompatActivity {

    String[] fiilliste;
    ArrayAdapter<String> adapter;
    View.OnClickListener mOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        ListView vlist = (ListView) findViewById(R.id.list);
        fiilliste = getResources().getStringArray(R.array.fi);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fiilliste);
        vlist.setAdapter(adapter);

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = fiilliste[position].toString();

                switch (position) {
                    case 0: // toast simple
                        SimpleActivity.start(MainActivity.this);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        break;
                    case 1:
                        ScrollableActivity.start(MainActivity.this);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                        break;
                    case 2:
                        OnlyIconsActivity.start(MainActivity.this);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        break;
                    case 3:
                        CustomIconTextActivity.start(MainActivity.this);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                        break;
                 default:
                }
            }
        });

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                return true;
            case R.id.action_github:
                String url = "https://github.com/cleidimarviana/tabs-material";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
