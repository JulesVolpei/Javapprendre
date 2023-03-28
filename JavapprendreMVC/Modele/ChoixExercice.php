<?php
final class ChoixExercice {
    private $pdo;

    public function __construct()
    {
        $this->pdo = Connection::getInstance()->pdo;
    }

}