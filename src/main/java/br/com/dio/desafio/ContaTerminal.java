package br.com.dio.desafio;

import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

  static void main( String[] args ) {
    try( Scanner input = new Scanner( System.in ) ) {
      System.out.printf( Locale.of( "pt", "BR" ),
                         "%nOlá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s e seu saldo de R$ %,.2f já está disponível para saque.%n",
                         getTexto( "Digite seu nome: ", input ),
                         getTexto( "Digite sua agencia: ", input ),
                         getTexto( "Digite sua conta: ", input ),
                         getDouble( "Digite o saldo: ", input ) );
    }
  }

  public static String getTexto( String titulo, Scanner input ) {
    String nomeCliente;
    do {
      System.out.print( titulo );
      nomeCliente = input.nextLine();
    } while( nomeCliente.trim().isEmpty() );
    return nomeCliente;
  }

  public static double getDouble( String titulo, Scanner input ) {
    do {
      System.out.print( titulo );
      try {
        return Double.parseDouble( input.nextLine().replace( ",", "." ) );
      }
      catch( NumberFormatException _ ) {
        System.out.println( "Valor inválido. Tente novamente." );
      }
    } while( true );
  }

}
