/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorfightrmi;

/**
 *
 * @author felipe.campos
 */
class Action {

    int status;

    int attack() {
        status = 1;
        return 2;
    }

    int couterAttack() {
        status = 2;
        return 2;
    }

    int defense() {
        status = 3;
        return 2;
    }
}
