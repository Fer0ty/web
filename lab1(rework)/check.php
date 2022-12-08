<?php

function checkValues($x,$y,$r): bool {
    if ($x!= '' && $y!= ''&&  $r != '') {

        $checkY = in_array($y, ['-2', '-1.5', '-1', '-0.5', '0', '0.5', '1', '1.5', '2']);
        $checkX = -3 <= (double) $x && (double) $x <= 5;
        $checkR = in_array($r, ['1', '1.5', '2', '2.5', '3']);
        return $checkX && $checkY && $checkR;
    }
    return false;
}

function checkHit($x, $y, $r): bool{
    if($x >= 0 && $y <= 0) {
        return ($x <= $r) && ($y >= ((-$r) / 2));
    } elseif ($x >= 0 && $y >= 0) {
        return (sqrt($x ** 2 + $y ** 2)) <= ($r / 2);
    }   elseif ($x <= 0 && $y >= 0) {
        //координаты углов треугольника
        //A(0,0) B(0,r/2) C(r/2,0)
        $x1 = 0;
        $x2 = 0;
        $x3 = -$r;
        $y1 = 0;
        $y2 = $r / 2;
        $y3 = 0;

        $X = ($x1 - $x) * ($y2 - $y1) - ($x2 - $x1) * ($y1 - $y);
        $Y = ($x2 - $x) * ($y3 - $y2) - ($x3 - $x2) * ($y2 - $y);
        $Z = ($x3 - $x) * ($y1 - $y3) - ($x1 - $x3) * ($y3 - $y);
        return (($X >= 0 && $Y >= 0 && $Z >= 0) || ($X <= 0 && $Y <= 0 && $Z <= 0));
    }

    else
        return false;
    }




session_start();
date_default_timezone_set('Europe/Moscow');
$start = microtime(true);
$isValid = true;

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $xStr = $_REQUEST['x'];
    $yStr = $_REQUEST['y'];
    $rStr = $_REQUEST['r'];
    $x = $xStr;
    $y = $yStr;
    $r = $rStr;
    $out = "";
    $now = date("H:i:s");
    $response = "";
    if (!isset($_SESSION['data'])) {
        $_SESSION['data'] = array();
    }
    if (checkValues($x,$y,$r)){
        if (checkHit($x,$y, $r)) {
            $out = "<span style='color: lime'>True</span>";
        } else {
            $out = "<span style='color: red'>False</span>";
        }
        $calc_time = microtime(true) - $start;
        $answer = array($xStr, $yStr, $rStr, $out, $now, number_format($calc_time, 10, ".", "") . " sec");
    } else {
        $answer = array('PLEASE', 'CHECK', 'YOUR', 'PARAMS', '!!', '!!');
    }
} else {
    $answer = array('PLEASE', 'USE', 'ANOTHER', 'METHOD', 'FOR', 'SENDING!');
}

$_SESSION['data'][] = $answer;
?>
<table align="center" class="result_table">
    <tr>
        <th class="variable">X</th>
        <th class="variable">Y</th>
        <th class="variable">R</th>
        <th>Result</th>
        <th>Submit time</th>
        <th>Calculation time</th>
    </tr>
    <?php
    foreach ($_SESSION['data'] as $word) { ?>
        <tr>
            <td><?php echo $word[0] ?></td>
            <td><?php echo $word[1] ?></td>
            <td><?php echo $word[2] ?></td>
            <td><?php echo $word[3] ?></td>
            <td><?php echo $word[4] ?></td>
            <td><?php echo $word[5] ?></td>
        </tr>
    <?php } ?>
</table>
