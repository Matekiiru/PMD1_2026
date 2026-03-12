package com.example.imcapp.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


import com.example.imcapp.model.Pessoa;

public  class Controle {

    //criei a lista
    private List<Pessoa> listaPessoas;


    // contructor pra inicialiar a lista
    public Controle() {
        listaPessoas = new ArrayList<>();
    }

    //metodo q vai adicionar as pessoa(LEMBRA DE PASSAR OS PARAMETROS)

    public void adicionarPessoa(String nome, String idadeStr, String pesoStr, String alturaStr) {
       int idade = Integer.parseInt(idadeStr.trim());
       double altura = Double.parseDouble(alturaStr.trim());
       double peso = Double.parseDouble(pesoStr.trim());
        //CRIA A PESSOA
        Pessoa p = new Pessoa(nome, idade, peso, altura);
            // ADICIONAR PESSOA
            listaPessoas.add(p);
    }
    public String getResultado(){
        String resultado=" ";
        for(Pessoa p : listaPessoas){
            //formata o double imc pra n ficar um bilhao de numeros
            DecimalFormat fmt = new DecimalFormat("#.##");
            fmt.setRoundingMode(RoundingMode.DOWN);
            double  imc = p.calcularIMC();
            //continua formataçao criando a imcft(imc formatado) e passa a string pra double
            String imcft = fmt.format(imc);
            Double.parseDouble(imcft);
            String categoria = categoriaIMC(imc);
            resultado += p.getNome()+"- IMC: "+imcft+"-"+categoria+"\n";
        }
        return resultado;


    }
    public String categoriaIMC(double imc ){
        String categoria = " ";
        if ( imc < 18){
            categoria = "abaixo do peso";
        } else if ( imc < 25) {
            categoria = "normal";
        }else if (imc < 30){
            categoria = "sobrepeso";
        }else if (imc > 30 ){
            categoria = "TITANICO!!!!!!!!!!!";
        }
        return categoria;
    }
    public int quantidadePessoas(){
        return listaPessoas.size();
   // teste
    }
}



