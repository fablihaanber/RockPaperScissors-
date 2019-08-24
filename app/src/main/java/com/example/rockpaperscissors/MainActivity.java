package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rock,paper,scissor;
    TextView userText,machineText;
    ImageView computerImage,userImage;
    int userScore=0,computerScore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rock=findViewById(R.id.rockButtonID);
        paper=findViewById(R.id.paperButtonID);
        scissor=findViewById(R.id.scissorButtonID);
        computerImage=findViewById(R.id.machineImageID);
        userImage=findViewById(R.id.humanImageID);
        userText=findViewById(R.id.userTextID);
        machineText=findViewById(R.id.computerTextID);
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImage.setImageResource(R.drawable.rockimage);
                String str=gameOn("Rock");
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                userText.setText("User: "+Integer.toString(userScore));
                machineText.setText("Computer: "+Integer.toString(computerScore));
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImage.setImageResource(R.drawable.paperimage);
                String str=gameOn("Paper");
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                userText.setText("User: "+Integer.toString(userScore));
                machineText.setText("Computer: "+Integer.toString(computerScore));
            }
        });
        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImage.setImageResource(R.drawable.scissorsimage);
                String str=gameOn("Scissors");
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                userText.setText("User: "+Integer.toString(userScore));
                machineText.setText("Computer: "+Integer.toString(computerScore));
            }
        });
    }
    public String gameOn(String userChoice){
        String computerChoice="";
        Random r=new Random();
        int computerChoiceNumber=r.nextInt(3)+1;
        if(computerChoiceNumber==1){
            computerChoice="Rock";
            //set the image for computer depending on choice
            computerImage.setImageResource(R.drawable.rockimage);

        }
        else if(computerChoiceNumber==2){
            computerChoice="Paper";
            //set the image for computer depending on choice
            computerImage.setImageResource(R.drawable.paperimage);

        }
        else if(computerChoiceNumber==3){
            computerChoice="Scissors";
            //set the image for computer depending on choice
            computerImage.setImageResource(R.drawable.scissorsimage);

        }
        //comparing human and computer choices to determine the winner
        if(userChoice==computerChoice){
            return "Draw.Nobody wins";

        }
        else if(userChoice=="Rock"&&computerChoice=="Paper"){
            computerScore++;
            return "Computer wins";

        }
        else if(userChoice=="Paper"&&computerChoice=="Rock"){
            userScore++;
            return "Congratulations!You win";

        }
        else if(userChoice=="Rock"&&computerChoice=="Scissors"){
            userScore++;
            return "Congratulations!You win";

        }
        else if(userChoice=="Scissors"&&computerChoice=="Rock"){
            computerScore++;
            return "Computer wins";

        }
        else if(userChoice=="Paper"&&computerChoice=="Scissors"){
            computerScore++;
            return "Computer wins";

        }
        else if(userChoice=="Scissors"&&computerChoice=="Paper"){
            userScore++;
            return "Congratulations!You win";

        }
        return "gameOver";
    }
}
