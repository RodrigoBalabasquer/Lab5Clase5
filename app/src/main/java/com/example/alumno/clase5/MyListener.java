package com.example.alumno.clase5;

import android.util.Log;
import android.view.View;

public class MyListener implements View.OnClickListener {
    MainActivity mainActivity;
    public  MyListener(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        Log.d("Click","algo");

        //mainActivity.personas.add(new PersonaModel("Cosme","Fulanito","6685-4798"));
        //mainActivity.adapter.notifyDataSetChanged();
        //mainActivity.personas.get(0).setApellido("lakjsdklashdalñk");
        //mainActivity.adapter.notifyItemChanged(0);
    }
}
