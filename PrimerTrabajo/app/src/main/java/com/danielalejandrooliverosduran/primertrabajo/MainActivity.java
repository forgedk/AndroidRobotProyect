package com.danielalejandrooliverosduran.primertrabajo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;

public class MainActivity extends ActionBarActivity {
    private ToggleButton BotonConectarIp;
    private SeekBar Control1 ;
    private SeekBar Control2 ;
    private SeekBar Control3 ;
    private SeekBar Control4 ;
    private SeekBar Control5 ;
    private SeekBar Control6 ;
    private EditText CampoDireccionIp;
    private TextView EstadoDeConexion;
    private TextView EstadoControl1;
    private TextView EstadoControl2;
    private TextView EstadoControl3;
    private TextView EstadoControl4;
    private TextView EstadoControl5;
    private TextView EstadoControl6;
    private TextView NombreDelPrimerIntegrante;
    private TextView NombreDelSegundoIntegrante;
    private TextView NombreDeLTercerIntegrante;
    private TextView TituloDeLaAplicacion;
    private Typeface FuenteParaLosEstadosDeControl;
    private SeekBarPersonalizado SeekbarPersonalizado1,SeekbarPersonalizado2,SeekbarPersonalizado3,SeekbarPersonalizado4,SeekbarPersonalizado5,SeekbarPersonalizado6,SeekbarPersonalizado7;
    public TCPClient mTcpClient;
    public String SERVERIP="169.254.89.138";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       InicarlizarTextViews();
       InicializarToggleButtons();
       InicializarSeekBars();
       InicializarEditText();
       InstanciarComportamientoToggleButtons();
       InstanciarComportamientoSeekBars();
        }

    public class connectTask extends AsyncTask<String,String,TCPClient>
    {
        protected  TCPClient doInBackground(String...message){
            mTcpClient=new TCPClient(new TCPClient.OnMessageReceived(){

                public void messageReceived(String message){
                    publishProgress(message);
                }
            });
            mTcpClient.IP(SERVERIP);
            mTcpClient.run();
            return null;
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void InicializarToggleButtons(){
        BotonConectarIp=(ToggleButton)findViewById((R.id.BotonConexionIP));
        BotonConectarIp.setTypeface(FuenteParaLosEstadosDeControl);
    }

  public void InicarlizarTextViews(){
      FuenteParaLosEstadosDeControl= InstanciarFuente("pixelart.ttf");
      NombreDelPrimerIntegrante=(TextView)findViewById((R.id.Integrante1)) ;
      NombreDelPrimerIntegrante.setTypeface(FuenteParaLosEstadosDeControl);
      NombreDelSegundoIntegrante=(TextView)findViewById((R.id.Integrante2)) ;
      NombreDelSegundoIntegrante.setTypeface(FuenteParaLosEstadosDeControl);
      NombreDeLTercerIntegrante=(TextView)findViewById((R.id.Integrante3)) ;
      NombreDeLTercerIntegrante.setTypeface(FuenteParaLosEstadosDeControl);
      TituloDeLaAplicacion=(TextView)findViewById((R.id.TituloIntegrantes)) ;
      TituloDeLaAplicacion.setTypeface(FuenteParaLosEstadosDeControl);
      EstadoDeConexion=(TextView)findViewById((R.id.EstadoDeConexion)) ;
      EstadoDeConexion.setTypeface(FuenteParaLosEstadosDeControl);
      EstadoControl1=(TextView)findViewById((R.id.TextoBarra1)) ;
      EstadoControl1.setTypeface(FuenteParaLosEstadosDeControl);
      EstadoControl2=(TextView)findViewById((R.id.TextoBarra2)) ;
      EstadoControl2.setTypeface(FuenteParaLosEstadosDeControl);
      EstadoControl3=(TextView)findViewById((R.id.TextoBarra3)) ;
      EstadoControl3.setTypeface(FuenteParaLosEstadosDeControl);
      EstadoControl4=(TextView)findViewById((R.id.TextoBarra4)) ;
      EstadoControl4.setTypeface(FuenteParaLosEstadosDeControl);
      EstadoControl5=(TextView)findViewById((R.id.TextoBarra5)) ;
      EstadoControl5.setTypeface(FuenteParaLosEstadosDeControl);
      EstadoControl6=(TextView)findViewById((R.id.TextoBarra6)) ;
      EstadoControl6.setTypeface(FuenteParaLosEstadosDeControl);
  }

    public void InicializarSeekBars(){
        Control1=(SeekBar)findViewById((R.id.BarraDeControl1)) ;
        Control1.setMax(100);
        Control2=(SeekBar)findViewById((R.id.BarraDeControl2)) ;
        Control2.setMax(200);
        Control3=(SeekBar)findViewById((R.id.BarraDeControl3)) ;
        Control3.setMax(255);
        Control4=(SeekBar)findViewById((R.id.BarraDeControl4)) ;
        Control4.setMax(30);
        Control5=(SeekBar)findViewById((R.id.BarraDeControl5)) ;
        Control5.setMax(400);
        Control6=(SeekBar)findViewById((R.id.BarraDeControl6)) ;
        Control6.setMax(900);
    }

    public void InstanciarComportamientoSeekBars(){
        SeekbarPersonalizado1= new SeekBarPersonalizado(1,Control1,EstadoControl1);
        SeekbarPersonalizado2= new SeekBarPersonalizado(2,Control2,EstadoControl2);
        SeekbarPersonalizado3= new SeekBarPersonalizado(3,Control3,EstadoControl3);
        SeekbarPersonalizado4= new SeekBarPersonalizado(4,Control4,EstadoControl4);
        SeekbarPersonalizado5= new SeekBarPersonalizado(5,Control5,EstadoControl5);
        SeekbarPersonalizado6= new SeekBarPersonalizado(6,Control6,EstadoControl6);

    }


    public void InicializarEditText(){
        CampoDireccionIp=(EditText)findViewById((R.id.CampoDeTextoIngresarIP));
        CampoDireccionIp.setTypeface(FuenteParaLosEstadosDeControl);
    }

     public  void InstanciarComportamientoToggleButtons(){
     BotonConectarIp.setOnCheckedChangeListener(InstanciarComportamientoBotonConectarIp());
     }

     public  CompoundButton.OnCheckedChangeListener InstanciarComportamientoBotonConectarIp() {
         return new CompoundButton.OnCheckedChangeListener() {
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     BotonConectarIp.setText("Desconectar");
                     EstadoDeConexion.setText("        Estado: Conectando a la Ip: " + CampoDireccionIp.getText());
                     new connectTask().execute("");
                     SERVERIP=CampoDireccionIp.getText().toString();

                 } else {
                     BotonConectarIp.setText("Conectar");
                     EstadoDeConexion.setText("        Estado: Desconectado");
                     try{
                         mTcpClient.stopClient();
                         EstadoDeConexion.setText("Detenido");
                     }catch(Throwable e){
                         e.printStackTrace();

                     }

                 }
             }
         };
     }
    public Typeface InstanciarFuente(String NombreDeLaFuenteAInstanciar){
        return Typeface.createFromAsset(getAssets(), NombreDeLaFuenteAInstanciar);
    }
    public void mensaje(){
        byte[] b= {(byte) SeekbarPersonalizado1.getValorDelProgreso(),(byte)SeekbarPersonalizado2.getValorDelProgreso(),(byte)SeekbarPersonalizado3.getValorDelProgreso(),(byte)SeekbarPersonalizado4.getValorDelProgreso(),(byte)SeekbarPersonalizado5.getValorDelProgreso(),(byte)SeekbarPersonalizado6.getValorDelProgreso()};
        String s="";
        try{
          s= new String(b,"UTF-8")  ;
        }
        catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        if(mTcpClient !=null){
            mTcpClient.sendMessage(s);
            EstadoDeConexion.setText(mTcpClient.conection());

        }
    }

    class SeekBarPersonalizado {
        private int NumeroDelSeekBar;
        private SeekBar SeekBarAsocaido;
        private int ValorDelProgreso;
        private TextView TextoAsociadoBarraDeControl;

        public int getNumeroDelSeekBar() {
            return NumeroDelSeekBar;
        }

        public void setNumeroDelSeekBar(int numeroDelSeekBar) {
            NumeroDelSeekBar = numeroDelSeekBar;
        }

        public SeekBar getSeekBarAsocaido() {
            return SeekBarAsocaido;
        }

        public void setSeekBarAsocaido(SeekBar seekBarAsocaido) {
            SeekBarAsocaido = seekBarAsocaido;
        }

        public int getValorDelProgreso() {
            return ValorDelProgreso;
        }

        public void setValorDelProgreso(int valorDelProgreso) {
            ValorDelProgreso = valorDelProgreso;
        }

        public TextView getTextoAsociadoBarraDeControl() {
            return TextoAsociadoBarraDeControl;
        }

        public void setTextoAsociadoBarraDeControl(TextView textoAsociadoBarraDeControl) {
            TextoAsociadoBarraDeControl = textoAsociadoBarraDeControl;
        }

        public  SeekBarPersonalizado(int NumeroDelSeekbar, SeekBar SeekbarNecesario, TextView TextoAsociadoBarraDeControl) {
            this.NumeroDelSeekBar=NumeroDelSeekbar;
            this.SeekBarAsocaido=SeekbarNecesario;
            this.TextoAsociadoBarraDeControl=TextoAsociadoBarraDeControl;
            this.SeekBarAsocaido.setOnSeekBarChangeListener(IniciarComportamientoBarraDeControlCambioDeColor());

        }

        public SeekBar.OnSeekBarChangeListener IniciarComportamientoBarraDeControlCambioDeColor() {
            return new SeekBar.OnSeekBarChangeListener() {
                int ValorDeCambio = 0;
                String TextoAsociadoBarraDeControlOriginal = TextoAsociadoBarraDeControl.getText().toString();

                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    ValorDeCambio = progress;
                    TextoAsociadoBarraDeControl.setText(TextoAsociadoBarraDeControlOriginal + " " + ValorDeCambio);//Probable necesidad de optimimizacion por otra funcion en vez del +
                    TextoAsociadoBarraDeControl.setTextColor(Color.rgb(ValorDeCambio, 3 * ValorDeCambio, 2 * ValorDeCambio));// Cambia el color del texto asociado a el seekbar1
                     ValorDelProgreso = progress;
                    mensaje();
                }


                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {


                }
            };
        }
    }
}
