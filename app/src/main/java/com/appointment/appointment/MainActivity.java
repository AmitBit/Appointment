package com.appointment.appointment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*reference = FirebaseDatabase.getInstance().getReference();
        User user = new User("300481736", "Lital", "Kapon", "0508447486", "litalkapon@gmail.com");
        reference.child("users").push().setValue(user);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new AsyncTask<DataSnapshot, Void, Void>() {
                    @Override
                    protected Void doInBackground(DataSnapshot... dataSnapshots) {

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {

                    }
                }.execute(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/



    }


}
