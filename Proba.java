import java.util.*;

public class ChiCuad {
//Cargo el Array de marcas
public static ArrayList CargoMarca(){
ArrayList marca= new ArrayList();
//int i=0;

marca.add(0);
marca.add(1);
marca.add(2);
marca.add(3);
marca.add(4);
return marca;
}

//Cargo el Array de probabilidades
public static ArrayList CargoProb(){
ArrayList prob= new ArrayList();
prob.add(0.08);
prob.add(0.17);
prob.add(0.26);
prob.add(0.35);
prob.add(0.14);
return prob;
}

//Cargo el Array de probabilidades acumuladas
public static ArrayList CargoAcum(){
ArrayList acum= new ArrayList();
acum.add(0.08);
acum.add(0.25);
acum.add(0.51);
acum.add(0.86);
acum.add(1.00);
return acum;
}

//Cargo Array de series
public static ArrayList CargoSerie(){
ArrayList serie=new ArrayList();
int i=0;

double sem= 1121;

while(i<=200){
double modu= 10000;
double pa= 37;
double r1= (pa*sem)%modu;
double alea= r1/modu;
serie.add(alea);
sem=0.0;
sem=r1;
i++;
}
return serie;
}

//Cargo el Array de muestra
public static ArrayList CargoMuestra(){
ArrayList miMuestra= new ArrayList();
ArrayList miSerie= CargoSerie();

ArrayList miAcum= CargoAcum();
ArrayList miMarca= CargoMarca();
int k=0;

while(k<=200){
for(int j=0;j<=miSerie.size();j++){
if(miSerie.get(j)<=miAcum.get(j)){
miMuestra.add(miMarca.get(j));
}
}
k++;
}
return miMuestra;

}

public static void main(String arg[]){
ArrayList fecob= new ArrayList();//Array de frecuencias observadas
ArrayList fectot= new ArrayList();//Array de frecuencia total

ArrayList marca= CargoMarca();
ArrayList prob= CargoProb();
ArrayList probAc= CargoAcum();

double n= 200;
int m= 5;
ArrayList muestra= CargoMuestra();
int i=0;
while(i<=n){
for(int j=0;j<muestra.size();j++){
                  if((muestra.get(i))==(marca.get(i))){
                      fecob.add(fecob.get(i)+1);
                  }
              }
              i++;
          }

          for(int j=0;j<prob.size();j++){
              fectot.add((prob.get(j))*200);
          }
          double ch=0.0;
          for(int j=0;j<=fecob.size();j++){
              //if(j>fecob.size()){
              //}
              Double u= Math.pow((fecob.get(j)-fectot.get(j)),2);
              ch+= u/(fectot.get(j));
          }
          System.out.println("chi cuadrado para un n=200 "+ch);

      }

}

