package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SummaryControlVerb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_control_verb);
        ArrayList<IrregularVerbQuestion> list = (ArrayList<IrregularVerbQuestion>) getIntent().getExtras().get("list");
        IrregularVerbQuestionListAdapter adapter = new IrregularVerbQuestionListAdapter(list, this);
        ListView listView =findViewById(R.id.listQuestion);
        listView.setAdapter(adapter);

        Button buttonConfirm = findViewById(R.id.confirmButton);
        buttonConfirm.setOnClickListener(e -> {
            for(IrregularVerbQuestion i : list)
            {
                i.correct();
            }
            Intent intent = new Intent(SummaryControlVerb.this, IrregularVerbScore.class);
            intent.putExtra("list", list);
            startActivity(intent);
            finish();
        });
    }

    public void startSaisiVerb(int position, ArrayList<IrregularVerbQuestion> list)
    {
        Intent intent = new Intent(SummaryControlVerb.this, IrregularVerbDisplay.class);
        intent.putExtra("id", position);
        intent.putExtra("list", list);
        startActivity(intent);
    }

}