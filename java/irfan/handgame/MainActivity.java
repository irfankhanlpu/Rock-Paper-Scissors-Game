package irfan.handgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button rock,paper,scissor,next;
    ImageView iv_cpu,iv_me;
    String myChoise,cpuchoise,result;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rock=(Button) findViewById(R.id.b_rock);
        paper=(Button) findViewById(R.id.b_paper);
        scissor=(Button) findViewById(R.id.b_scissors);
        next=(Button) findViewById(R.id.b_next);
        iv_cpu=(ImageView) findViewById(R.id.iv_cpu);
        iv_me=(ImageView) findViewById(R.id.iv_me);

        r=new Random();
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise="rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise="paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });
        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise="scissors";
                iv_cpu.setImageResource(R.drawable.scissor);
                calculate();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent i=new Intent(MainActivity.this,amir.class);
                startActivity(i);
            }
        });
    }

    public void calculate()
    {
        int cpu=r.nextInt(3);
        if(cpu==0)
        {
            cpuchoise="rock";
            iv_cpu.setImageResource(R.drawable.rock);
        }
        else if(cpu==1)
        {
            cpuchoise="paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if(cpu==2)
        {
            cpuchoise="scissors";
            iv_cpu.setImageResource(R.drawable.scissor);
        }
        if(myChoise.equals("rock") && cpuchoise.equals("paper"))
        {
            result="you loos!";
        }
        else if(myChoise.equals("rock") && cpuchoise.equals("scissors"))
        {
            result="you win!";
        }

        else if(myChoise.equals("paper") && cpuchoise.equals("rock"))
        {
            result="you win!";
        }
        else if(myChoise.equals("paper") && cpuchoise.equals("scissors"))
        {
            result="you loos!";
        }

        else if(myChoise.equals("scissors") && cpuchoise.equals("paper"))
        {
            result="you win!";
        }
        else if(myChoise.equals("scissors") && cpuchoise.equals("rock"))
        {
            result="you loos!";
        }
        else if(myChoise.equals("scissors") && cpuchoise.equals("scissors"))
        {
            result="Draw!";
        }

        else if(myChoise.equals("rock") && cpuchoise.equals("rock"))
        {
            result="Draw!";
        }

        else if(myChoise.equals("paper") && cpuchoise.equals("paper"))
        {
            result="Draw!";
        }

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
