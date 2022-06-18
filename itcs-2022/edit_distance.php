<?php
$fh = fopen('php://stdin', 'r');
$number = fgets($fh);
function DamerauLevenshtein($S1, $S2) {
    $L1 = strlen($S1);
    $L2 = strlen($S2);
    $matrix = [[]];

    // delete
    for ($i = 0; $i <= $L1; $i += 1) {
        $matrix[$i][0] = $i > 0 ? $matrix[$i - 1][0] + 1 : 0;
    }
    // insert
    for ($i = 0; $i <= $L2; $i += 1) {
        $matrix[0][$i] = $i > 0 ? $matrix[0][$i - 1] + 1 : 0;
    }
    for ($i = 1; $i <= $L1; $i += 1) {
        $cOne = substr($S1, $i - 1, 1);
        for ($j = 1; $j <= $L2; $j += 1) {
            $cTwo = substr($S2, $j - 1, 1);
            $cost = $cOne === $cTwo ? 0 : 1;
            $del = $matrix[$i - 1][$j] + 1;

            // Insertion cost
            $ins = $matrix[$i][$j - 1] + 1;

            // Substitution cost
            $sub = $matrix[$i - 1][$j - 1] + $cost;

            // Compute optimal
            $matrix[$i][$j] = min($del, $ins, $sub);

            // Transposition cost
            if ($i > 1 && $j > 1) {
                $ccOne = substr($S1, $i - 2, 1);
                $ccTwo = substr($S2, $j - 2, 1);
                if ($cOne === $ccTwo && $ccOne === $cTwo) {
                    $matrix[$i][$j] = min($matrix[$i][$j], $matrix[$i - 2][$j - 2] + $cost);
                }
            }
        }
    }
    return $matrix[$L1][$L2];
}
for ($x = 0; $x < $number; $x++) {
    $source = trim(fgets($fh));
    $destination = trim(fgets($fh));
    echo DamerauLevenshtein($source, $destination) . "\n";
}