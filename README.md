ResCalculator
=============

Calculator to calculate the resistance of a circuit

=============

Usage: java circuitmain <input file>

Input file needs to be in the same directory as the .class

'#' will be read as comments

List the series and parrallel resistances in order as they appear in the ciruit

Define the type of the circuit followed by a '{' on the next line and close it with '}'

Label each resistor as 'resistor <value>'

# Example input file:
<pre><code>
  # circuit specification
  series # series circuit
  {
  parallel # parallel circuit
  {
  resistor 3.2, # simple resistor
  resistor 4.1
  },
  series
  {
  resistor 1.0,
  parallel
  {
  resistor 1.0,
  resistor 2.0
  },
  series 
  {
  resistor 3.2,
  resistor 4.0
  }
  }
  }
</code></pre>
