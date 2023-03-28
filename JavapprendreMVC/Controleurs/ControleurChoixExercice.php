<?php

final class ControleurChoixExercice
{
    public function defautAction()
    {
        $O_choixExercice =  new ChoixExercice();
        Vue::montrer('ChoixExercice/voir');

    }

}