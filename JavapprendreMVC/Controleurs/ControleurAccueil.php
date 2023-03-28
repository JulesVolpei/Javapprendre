<?php

final class ControleurAccueil
{
    public function defautAction()
    {
        $O_accueil =  new Accueil();
        Vue::montrer('Accueil/voir');

    }

    public function testformAction(Array $A_parametres = null, Array $A_postParams = null)
    {

        Vue::montrer('Accueil/testform', array('formData' =>  $A_postParams));

    }

}