<?php
$fh = fopen('php://stdin', 'r');
$number = $userInput = fgets($fh);
$roman = array(
    "I" => 1,
    "V" => 5,
    "X" => 10,
    "L" => 50,
    "C" => 100,
    "D" => 500,
    "M" => 1000
);
for ($x = 0; $x < $number; $x++) {
    $required = trim(fgets($fh));
    $length = strlen($required);
    $sum = 0;
    for ($i=0; $i<$length; $i++) {
        $r = $roman[$required[$i]];
        if ($i + 1 < $length) {
            $next = $roman[$required[$i+1]];
            if ($next > $r) {
                $r = -$r;
            }
        }
        $sum += $r;
    }
    echo $sum . "\n";
}