<?php
session_start();
if (isset($_SESSION['data'])) {
    $_SESSION['data'] = array();
}
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
</table>