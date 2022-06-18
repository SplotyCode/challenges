<?php
$generated=2;
$fib_array = [0, 1];
function fib($n) {
    global $generated, $fib_array;
    for ($i = $generated; $i <= $n; $i++) {
        $fib_array[$i] = $fib_array[$i - 1] + $fib_array[$i - 2];
        $generated++;
    }
    return $fib_array[$n];
}

$fh = fopen('php://stdin', 'r');
$number = $userInput = fgets($fh);
for ($x = 0; $x < $number; $x++) {
  $required = fgets($fh);
  #echo "try " . $required;
  $count = 0;
  $all = 0;
  $sum = 0;
  while ($count < $required) {
      $current = fib($all);
      #echo "for " . $all . " " . $current . " " . $count . "\n";
      if ($current % 2 != 0) {
          #echo $current . "\n";
          $count++;
          $sum +=  (int) $current;
      }
      $all++;
  }
  echo $sum . "\n";
}