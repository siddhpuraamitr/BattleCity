/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefield;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class battlefield extends JFrame implements Runnable, KeyListener {

    JLabel label[] = new JLabel[700];
    int remem[] = new int[700];
    int cle[] = new int[700];
    int bul[] = new int[519];
    int ebul[] = new int[519];
    int ebulL[], el[];
    boolean eflag[] = {false, false, false}, space = true, espace[] = {true, true, true};
    String estr1[], estr[];
    int eprePos[];  //0=up;  1==down;  2==left;   3==Right;
    int t[], t1[];
    Enemy o1[];
    int k = 0, l = 0, bulL = 0, change = 1, si, si1, pos1, time, score = 0, life = 5;
    boolean flag = false;
    String str1 = "";
    int pos[] = new int[7];
    int prePos = 0;    //0=up;  1==down;  2==left;   3==Right;
    Thread th;
    ImageIcon b, w, green;

    battlefield() {
        time = 100;
        estr = new String[3];
        estr1 = new String[3];
        eprePos = new int[3];
        ebulL = new int[3];
        el = new int[3];

        t = new int[3];
        t1 = new int[3];
        for (int er = 0; er < 3; er++) {
            estr[er] = "Up";
            estr1[er] = "";
            t[er] = 10;

            eprePos[er] = 0;
            ebulL[er] = 0;
            el[er] = 0;
        }
        o1 = new Enemy[3];
        o1[0] = new Enemy();
        o1[1] = new Enemy();
        o1[2] = new Enemy();
        setLayout(null);
        addKeyListener(this);
        b = new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/battlefield/src/battlefield/a.png");
        // b = new ImageIcon("/home/amit/NetBeansProjects/battlefield/src/battlefield/a.png");
        w = new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/battlefield/src/battlefield/a.png");
        for (int i = 0; i < 601; i++) {
            label[i] = new JLabel();
        }

        for (int i = 0; i < 520; i = i + 20) {
            for (int j = 0; j < 400; j = j + 20) {
                label[k].setBounds(j, i, 20, 20);

                //  label[k].setBorder(BorderFactory.createLineBorder(Color.black));
                add(label[k]);
                k++;

            }
        }
        label[600].setBounds(420, 0, 80, 80);
        label[600].setFont(new Font("Arial", Font.BOLD, 40));
        label[600].setText(score + "");
        label[599].setBounds(410, 50, 120, 80);
        label[599].setFont(new Font("Arial", Font.BOLD, 20));
        label[599].setText("High Score");
        label[598].setBounds(410, 150, 120, 80);
        label[598].setFont(new Font("Arial", Font.BOLD, 20));
        label[597].setBounds(410, 200, 120, 80);
        label[597].setFont(new Font("Arial", Font.BOLD, 20));
        label[596].setBounds(410, 250, 120, 80);
        label[596].setFont(new Font("Arial", Font.BOLD, 20));
        label[596].setText("Life");
        label[597].setText(life + "");
        add(label[600]);
        add(label[599]);
        add(label[598]);
        add(label[597]);
        add(label[596]);

        car(0);

        o1[0].epos[0] = 28;
        o1[0].epos[1] = 47;
        o1[0].epos[2] = 48;
        o1[0].epos[3] = 49;
        o1[0].epos[4] = 67;
        o1[0].epos[5] = 69;

        o1[1].epos[0] = 22;
        o1[1].epos[1] = 41;
        o1[1].epos[2] = 42;
        o1[1].epos[3] = 43;
        o1[1].epos[4] = 61;
        o1[1].epos[5] = 63;

        o1[2].epos[0] = 37;
        o1[2].epos[1] = 56;
        o1[2].epos[2] = 57;
        o1[2].epos[3] = 58;
        o1[2].epos[4] = 76;
        o1[2].epos[5] = 78;

        setSize(600, 600);

        th = new Thread(this);
        th.start();

    }

    public void run() {
        while (true) {

            draw();
            randomMovement();

            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
            }

            border();
            clear();

        }
    }

    public void drawebulLet() {

        for (int er = 0; er < 3; er++) {
            if (eflag[er]) {
                System.out.println("eprepos[er]" + eprePos[er]);
                estr1[er] = eprePos[er] + "";
                ebul[er] = o1[er].epos[0];
                ebulL[er] = el[er];
            }
        }
    }

    public void drawBullet() {

        if (flag) {
            str1 = prePos + "";
            bul[0] = pos[0];
            bulL = l;

        }

    }

    public void movebulLet() {
//        System.out.println("str1 === "+str1);

        if (str1.equals("0")) {
            if (1 != bul[0] + bulL && 2 != bul[0] + bulL && 3 != bul[0] + bulL && 4 != bul[0] + bulL && 5 != bul[0] + bulL && 6 != bul[0] + bulL && 7 != bul[0] + bulL && 8 != bul[0] + bulL && 9 != bul[0] + bulL && 10 != bul[0] + bulL && 11 != bul[0] + bulL && 12 != bul[0] + bulL && 13 != bul[0] + bulL && 14 != bul[0] + bulL && 15 != bul[0] + bulL && 16 != bul[0] + bulL && 17 != bul[0] + bulL && 18 != bul[0] + bulL && 19 != bul[0] + bulL) {
                bulL -= 20;
                flag = false;
                //     space=true;
                remem[bul[0] + bulL] = 1;

            } else {
                space = true;
            }
        } else if (str1.equals("1")) {
            if (501 != bul[0] + bulL && 502 != bul[0] + bulL && 503 != bul[0] + bulL && 504 != bul[0] + bulL && 505 != bul[0] + bulL && 506 != bul[0] + bulL && 507 != bul[0] + bulL && 508 != bul[0] + bulL && 509 != bul[0] + bulL && 510 != bul[0] + bulL && 511 != bul[0] + bulL && 512 != bul[0] + bulL && 513 != bul[0] + bulL && 514 != bul[0] + bulL && 515 != bul[0] + bulL && 516 != bul[0] + bulL && 517 != bul[0] + bulL && 518 != bul[0] + bulL && 519 != bul[0] + bulL) {
                bulL += 20;
                flag = false;
                //  space=true;
                remem[bul[0] + bulL] = 1;
            } else {
                space = true;
            }
        } else if (str1.equals("2")) {

            if (20 != bul[0] + bulL && 40 != bul[0] + bulL && 60 != bul[0] + bulL && 80 != bul[0] + bulL && 100 != bul[0] + bulL && 120 != bul[0] + bulL && 140 != bul[0] + bulL && 160 != bul[0] + bulL && 180 != bul[0] + bulL && 200 != bul[0] + bulL && 220 != bul[0] + bulL && 240 != bul[0] + bulL && 260 != bul[0] + bulL && 280 != bul[0] + bulL && 300 != bul[0] + bulL && 320 != bul[0] + bulL && 340 != bul[0] + bulL && 360 != bul[0] + bulL && 380 != bul[0] + bulL && 400 != bul[0] + bulL && 420 != bul[0] + bulL && 440 != bul[0] + bulL && 460 != bul[0] + bulL && 480 != bul[0] + bulL) {
                bulL -= 1;
                //space=true;
                flag = false;
                remem[bul[0] + bulL] = 1;
            } else {
                space = true;
            }
        } else if (str1.equals("3")) {

            if (39 != bul[0] + bulL && 59 != bul[0] + bulL && 79 != bul[0] + bulL && 99 != bul[0] + bulL && 119 != bul[0] + bulL && 139 != bul[0] + bulL && 159 != bul[0] + bulL && 179 != bul[0] + bulL && 199 != bul[0] + bulL && 219 != bul[0] + bulL && 239 != bul[0] + bulL && 259 != bul[0] + bulL && 279 != bul[0] + bulL && 299 != bul[0] + bulL && 319 != bul[0] + bulL && 339 != bul[0] + bulL && 359 != bul[0] + bulL && 379 != bul[0] + bulL && 399 != bul[0] + bulL && 419 != bul[0] + bulL && 439 != bul[0] + bulL && 459 != bul[0] + bulL && 479 != bul[0] + bulL && 499 != bul[0] + bulL) {
                bulL += 1;
                // space=true;
                flag = false;
                remem[bul[0] + bulL] = 1;
            } else {
                space = true;
            }
        }
        for (int er = 0; er < 3; er++) {
            for (int i = 0; i < 6; i++) {
                if (bul[0] + bulL == o1[er].epos[i] + el[er]) {

                    eprePos[er] = 0;
                    el[er] = 0;
                    carEnemy(er);
                    label[600].setText("" + (score += 10));
                }
            }
        }

    }

    public void carEnemy(int i) {
        switch (i) {
            case 0:
                o1[0].epos[0] = 28;
                o1[0].epos[1] = 47;
                o1[0].epos[2] = 48;
                o1[0].epos[3] = 49;
                o1[0].epos[4] = 67;
                o1[0].epos[5] = 69;
                break;
            case 1:
                o1[1].epos[0] = 22;
                o1[1].epos[1] = 41;
                o1[1].epos[2] = 42;
                o1[1].epos[3] = 43;
                o1[1].epos[4] = 61;
                o1[1].epos[5] = 63;

                break;
            case 2:
                o1[2].epos[0] = 37;
                o1[2].epos[1] = 56;
                o1[2].epos[2] = 57;
                o1[2].epos[3] = 58;
                o1[2].epos[4] = 76;
                o1[2].epos[5] = 78;

                break;

        }

//
    }

    public void border() {
        for (int i = 0; i <= 500; i = i + 20) {
            remem[i] = 1;

        }

        for (int i = 500; i <= 519; i++) {
            remem[i] = 1;
            //label[i].setIcon(b);
        }

        for (int i = 19; i <= 519; i = i + 20) {
            remem[i] = 1;
            // label[i].setIcon(b);
        }

        for (int i = 0; i <= 19; i++) {
            remem[i] = 1;
            // label[i].setIcon(b);
        }

    }

    public void emovebulLet() {
        for (int er = 0; er < 3; er++) {
            if (estr1[er].equals("0")) {
                if (1 != ebul[er] + ebulL[er] && 2 != ebul[er] + ebulL[er] && 3 != ebul[er] + ebulL[er] && 4 != ebul[er] + ebulL[er] && 5 != ebul[er] + ebulL[er] && 6 != ebul[er] + ebulL[er] && 7 != ebul[er] + ebulL[er] && 8 != ebul[er] + ebulL[er] && 9 != ebul[er] + ebulL[er] && 10 != ebul[er] + ebulL[er] && 11 != ebul[er] + ebulL[er] && 12 != ebul[er] + ebulL[er] && 13 != ebul[er] + ebulL[er] && 14 != ebul[er] + ebulL[er] && 15 != ebul[er] + ebulL[er] && 16 != ebul[er] + ebulL[er] && 17 != ebul[er] + ebulL[er] && 18 != ebul[er] + ebulL[er] && 19 != ebul[er] + ebulL[er]) {
                    ebulL[er] -= 20;
                    eflag[er] = false;
                    remem[ebul[er] + ebulL[er]] = 1;
                    System.out.println("ebul[er] = " + ebul[er] + "  ebulL[er]  = " + ebulL[er]);
                } else {
                    espace[er] = true;
                }
            } else if (estr1[er].equals("1")) {
                if (501 != ebul[er] + ebulL[er] && 502 != ebul[er] + ebulL[er] && 503 != ebul[er] + ebulL[er] && 504 != ebul[er] + ebulL[er] && 505 != ebul[er] + ebulL[er] && 506 != ebul[er] + ebulL[er] && 507 != ebul[er] + ebulL[er] && 508 != ebul[er] + ebulL[er] && 509 != ebul[er] + ebulL[er] && 510 != ebul[er] + ebulL[er] && 511 != ebul[er] + ebulL[er] && 512 != ebul[er] + ebulL[er] && 513 != ebul[er] + ebulL[er] && 514 != ebul[er] + ebulL[er] && 515 != ebul[er] + ebulL[er] && 516 != ebul[er] + ebulL[er] && 517 != ebul[er] + ebulL[er] && 518 != ebul[er] + ebulL[er] && 519 != ebul[er] + ebulL[er]) {
                    ebulL[er] += 20;
                    eflag[er] = false;
                    remem[ebul[er] + ebulL[er]] = 1;
                    System.out.println("ebul[er] = " + ebul[er] + "  ebulL[er]  = " + ebulL[er]);
                } else {
                    espace[er] = true;
                }
            } else if (estr1[er].equals("2")) {

                if (20 != ebul[er] + ebulL[er] && 40 != ebul[er] + ebulL[er] && 60 != ebul[er] + ebulL[er] && 80 != ebul[er] + ebulL[er] && 100 != ebul[er] + ebulL[er] && 120 != ebul[er] + ebulL[er] && 140 != ebul[er] + ebulL[er] && 160 != ebul[er] + ebulL[er] && 180 != ebul[er] + ebulL[er] && 200 != ebul[er] + ebulL[er] && 220 != ebul[er] + ebulL[er] && 240 != ebul[er] + ebulL[er] && 260 != ebul[er] + ebulL[er] && 280 != ebul[er] + ebulL[er] && 300 != ebul[er] + ebulL[er] && 320 != ebul[er] + ebulL[er] && 340 != ebul[er] + ebulL[er] && 360 != ebul[er] + ebulL[er] && 380 != ebul[er] + ebulL[er] && 400 != ebul[er] + ebulL[er] && 420 != ebul[er] + ebulL[er] && 440 != ebul[er] + ebulL[er] && 460 != ebul[er] + ebulL[er] && 480 != ebul[er] + ebulL[er]) {
                    ebulL[er] -= 1;

                    eflag[er] = false;
                    remem[ebul[er] + ebulL[er]] = 1;
                    System.out.println("ebul[er] = " + ebul[er] + "  ebulL[er]  = " + ebulL[er]);
                } else {
                    espace[er] = true;
                }
            } else if (estr1[er].equals("3")) {

                if (39 != ebul[er] + ebulL[er] && 59 != ebul[er] + ebulL[er] && 79 != ebul[er] + ebulL[er] && 99 != ebul[er] + ebulL[er] && 119 != ebul[er] + ebulL[er] && 139 != ebul[er] + ebulL[er] && 159 != ebul[er] + ebulL[er] && 179 != ebul[er] + ebulL[er] && 199 != ebul[er] + ebulL[er] && 219 != ebul[er] + ebulL[er] && 239 != ebul[er] + ebulL[er] && 259 != ebul[er] + ebulL[er] && 279 != ebul[er] + ebulL[er] && 299 != ebul[er] + ebulL[er] && 319 != ebul[er] + ebulL[er] && 339 != ebul[er] + ebulL[er] && 359 != ebul[er] + ebulL[er] && 379 != ebul[er] + ebulL[er] && 399 != ebul[er] + ebulL[er] && 419 != ebul[er] + ebulL[er] && 439 != ebul[er] + ebulL[er] && 459 != ebul[er] + ebulL[er] && 479 != ebul[er] + ebulL[er] && 499 != ebul[er] + ebulL[er]) {
                    ebulL[er] += 1;

                    eflag[er] = false;
                    remem[ebul[er] + ebulL[er]] = 1;
                    System.out.println("ebul[er] = " + ebul[er] + "  ebulL[er]  = " + ebulL[er]);
                } else {
                    espace[er] = true;
                }
            }
            if (ebul[er] + ebulL[er] == pos[0] + l || ebul[er] + ebulL[er] == pos[1] + l || ebul[er] + ebulL[er] == pos[2] + l || ebul[er] + ebulL[er] == pos[3] + l || ebul[er] + ebulL[er] == pos[4] + l || ebul[er] + ebulL[er] == pos[5] + l) {
                l = 0;
                prePos = 0;
                car(l);
                label[597].setText("" + (--life));

            }
        }
    }

    public void draw() {

        for (int i = 1; i <= 501; i += 20) {
            for (int j = i; j <= i + 19; j++) {
                remem[j] = 0;

            }
        }
        remem[pos[0] + l] = 1;
        remem[pos[1] + l] = 1;
        remem[pos[2] + l] = 1;
        remem[pos[3] + l] = 1;
        remem[pos[4] + l] = 1;
        remem[pos[5] + l] = 1;

        for (int er = 0; er < 3; er++) {
            remem[o1[er].epos[0] + el[er]] = 1;
            remem[o1[er].epos[1] + el[er]] = 1;
            remem[o1[er].epos[2] + el[er]] = 1;
            remem[o1[er].epos[3] + el[er]] = 1;
            remem[o1[er].epos[4] + el[er]] = 1;
            remem[o1[er].epos[5] + el[er]] = 1;
        }
        movebulLet();
        emovebulLet();

    }

    public void clear() {
        for (int i = 0; i < 520; i++) {

            if (remem[i] == 0) {
                label[i].setIcon(null);
            } else {
                label[i].setIcon(b);
            }
        }

    }

    public static void main(String[] args) {
        battlefield ob = new battlefield();

        //Thread t2=new Thread(this);
        //t2.start();
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setVisible(true);

    }

    public void keyTyped(KeyEvent e) {
    }

    public void car(int si) {
        if (life > 0) {//   |
            pos[0] = 448;                    // |||
            pos[1] = 467;                    // | |
            pos[2] = 468;
            pos[3] = 469;
            pos[4] = 487;
            pos[5] = 489;

        } else {
            JOptionPane.showMessageDialog(this, "Game Over");
            System.exit(1);
        }

    }

    public void keyReleased(KeyEvent e) {
        switch ((e.getKeyCode())) {
            case 37:
                switch (prePos) {
                    case 0:
                        pos[0] += 19;
                        pos[1] += 21;
                        pos[2] += 0;
                        pos[3] += -21;
                        pos[4] += 2;
                        pos[5] += -40;

                        break;
                    case 1:
                        pos[0] += -21;
                        pos[1] += 19;
                        pos[2] += 0;
                        pos[3] += -19;
                        pos[4] += 40;
                        pos[5] += 2;

                        break;

                    case 2:
                        int go = 1;
                         {
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 3; j++) {
                                    for (int k = 0; k < 6; k++) {
                                        if (o1[j].epos[k] + el[j] == pos[i] - 1 + l) {
                                            go = 0;

                                        }
                                    }
                                }
                            }

                            if (go == 1) {
                                l -= 1;
                            }
                        }

                        break;

                    case 3:
                        pos[0] += -2;
                        pos[1] += 40;
                        pos[2] += 0;
                        pos[3] += -40;
                        pos[4] += 42;
                        pos[5] += -38;

                        break;

                }
                prePos = 2;

                break;
            case 38:
                switch (prePos) {
                    case 0:                      //up
                        int go = 1;

                        if (0 != pos[0] - 20 + l && 1 != pos[0] - 20 + l && 2 != pos[0] - 20 + l && 3 != pos[0] - 20 + l && 4 != pos[0] - 20 + l && 5 != pos[0] - 20 + l && 6 != pos[0] - 20 + l && 7 != pos[0] - 20 + l && 8 != pos[0] - 20 + l && 9 != pos[0] - 20 + l && 10 != pos[0] - 20 + l && 11 != pos[0] - 20 + l && 12 != pos[0] - 20 + l && 13 != pos[0] - 20 + l && 14 != pos[0] - 20 + l && 15 != pos[0] - 20 + l && 16 != pos[0] - 20 + l && 17 != pos[0] - 20 + l && 18 != pos[0] - 20 + l && 19 != pos[0] - 20 + l) {
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 3; j++) {
                                    for (int k = 0; k < 6; k++) {
                                        if (o1[j].epos[k] + el[j] == pos[i] - 20 + l) {
                                            go = 0;

                                        }
                                    }
                                }
                            }

                            if (go == 1) {
                                l -= 20;
                            }

                        }

                        break;
                    case 1:                  //down
                        pos[0] += -40;
                        pos[1] += -2;
                        pos[2] += 0;
                        pos[3] += 2;
                        pos[4] += 38;
                        pos[5] += 42;

                        break;

                    case 2:                      //left
                        pos[0] += -19;
                        pos[1] += -21;
                        pos[2] += 0;
                        pos[3] += 21;
                        pos[4] += -2;
                        pos[5] += 40;

                        break;

                    case 3:                      //right
                        pos[0] += -21;
                        pos[1] += 19;
                        pos[2] += 0;
                        pos[3] += -19;
                        pos[4] += 40;
                        pos[5] += 2;

                        break;

                }
                prePos = 0;
                break;
            case 39:
                switch (prePos) {
                    case 0:                      //up
                        pos[0] += 21;
                        pos[1] += -19;
                        pos[2] += 0;
                        pos[3] += 19;
                        pos[4] += -40;
                        pos[5] += -2;

                        break;
                    case 1:                  //down
                        pos[0] += -19;
                        pos[1] += -21;
                        pos[2] += 0;
                        pos[3] += 21;
                        pos[4] += -2;
                        pos[5] += 40;

                        break;

                    case 2:                      //left
                        pos[0] += 2;
                        pos[1] += -40;
                        pos[2] += 0;
                        pos[3] += 40;
                        pos[4] += -42;
                        pos[5] += 38;

                        break;

                    case 3:                      //right
                        int go = 1;
                        if (19 != pos[0] + 1 + l && 39 != pos[0] + 1 + l && 59 != pos[0] + 1 + l && 79 != pos[0] + 1 + l && 99 != pos[0] + 1 + l && 119 != pos[0] + 1 + l && 139 != pos[0] + 1 + l && 159 != pos[0] + 1 + l && 179 != pos[0] + 1 + l && 199 != pos[0] + 1 + l && 219 != pos[0] + 1 + l && 239 != pos[0] + 1 + l && 259 != pos[0] + 1 + l && 279 != pos[0] + 1 + l && 299 != pos[0] + 1 + l && 319 != pos[0] + 1 + l && 339 != pos[0] + 1 + l && 359 != pos[0] + 1 + l && 379 != pos[0] + 1 + l && 399 != pos[0] + 1 + l && 419 != pos[0] + 1 + l && 439 != pos[0] + 1 + l && 459 != pos[0] + 1 + l && 479 != pos[0] + 1 + l && 499 != pos[0] + 1 + l) {
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 3; j++) {
                                    for (int k = 0; k < 6; k++) {
                                        if (o1[j].epos[k] + el[j] == pos[i] + 1 + l) {
                                            go = 0;

                                        }
                                    }
                                }
                            }

                            if (go == 1) {
                                l += 1;
                            }
                        }

                        break;

                }
                prePos = 3;

                break;
            case 40:
                switch (prePos) {
                    case 0:                      //up
                        pos[0] += 40;
                        pos[1] += 2;
                        pos[2] += 0;
                        pos[3] += -2;
                        pos[4] += -38;
                        pos[5] += -42;

                        break;
                    case 1:
                        //down
                        int go = 1;

                        if (501 != pos[0] + 20 + l && 502 != pos[0] + 20 + l && 503 != pos[0] + 20 + l && 504 != pos[0] + 20 + l && 505 != pos[0] + 20 + l && 506 != pos[0] + 20 + l && 507 != pos[0] + 20 + l && 508 != pos[0] + 20 + l && 509 != pos[0] + 20 + l && 510 != pos[0] + 20 + l && 511 != pos[0] + 20 + l && 512 != pos[0] + 20 + l && 513 != pos[0] + 20 + l && 514 != pos[0] + 20 + l && 515 != pos[0] + 20 + l && 516 != pos[0] + 20 + l && 517 != pos[0] + 20 + l && 518 != pos[0] + 20 + l && 519 != pos[0] + 20 + l) {
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 3; j++) {
                                    for (int k = 0; k < 6; k++) {
                                        if (o1[j].epos[k] + el[j] == pos[i] + 20 + l) {
                                            go = 0;

                                        }
                                    }
                                }
                            }

                            if (go == 1) {
                                l += 20;
                            }

                        }

                        break;

                    case 2:                      //left
                        pos[0] += 21;
                        pos[1] += -19;
                        pos[2] += 0;
                        pos[3] += 19;
                        pos[4] += -40;
                        pos[5] += -2;

                        break;

                    case 3:                      //right
                        pos[0] += 19;
                        pos[1] += 21;
                        pos[2] += 0;
                        pos[3] += -21;
                        pos[4] += 2;
                        pos[5] += -40;

                        break;

                }
                prePos = 1;
                break;
            case 32:
                flag = true;
                space = false;
                drawBullet();
                break;
        }

    }

    public void keyPressed(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void randomMovement() {

        for (int er = 0; er < 3; er++) {

            if (t[er] == 0) {

                t[er] = (int) (Math.random() * 20);
                t1[er] = (int) (Math.random() * 5);
                switch (t1[er]) {

                    case 0:
                        estr[er] = "Left";
                        break;
                    case 1:
                        estr[er] = "Right";
                        break;
                    case 2:
                        estr[er] = "Up";
                        break;
                    case 3:
                        estr[er] = "Down";
                        break;
                    case 4:
                        estr[er] = "Space";
                        break;

                }

            } else {
                t[er]--;
                if (estr[er].equals("Left")) {
                    switch (eprePos[er]) {
                        case 0:
                            o1[er].epos[0] += 19;
                            o1[er].epos[1] += 21;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += -21;
                            o1[er].epos[4] += 2;
                            o1[er].epos[5] += -40;

                            break;
                        case 1:
                            o1[er].epos[0] += -21;
                            o1[er].epos[1] += 19;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += -19;
                            o1[er].epos[4] += 40;
                            o1[er].epos[5] += 2;

                            break;

                        case 2:
                            int ego = 1;

                            if (20 != o1[er].epos[0] - 1 + el[er] && 40 != o1[er].epos[0] - 1 + el[er] && 60 != o1[er].epos[0] - 1 + el[er] && 80 != o1[er].epos[0] - 1 + el[er] && 100 != o1[er].epos[0] - 1 + el[er] && 120 != o1[er].epos[0] - 1 + el[er] && 140 != o1[er].epos[0] - 1 + el[er] && 160 != o1[er].epos[0] - 1 + el[er] && 180 != o1[er].epos[0] - 1 + el[er] && 200 != o1[er].epos[0] - 1 + el[er] && 220 != o1[er].epos[0] - 1 + el[er] && 240 != o1[er].epos[0] - 1 + el[er] && 260 != o1[er].epos[0] - 1 + el[er] && 280 != o1[er].epos[0] - 1 + el[er] && 300 != o1[er].epos[0] - 1 + el[er] && 320 != o1[er].epos[0] - 1 + el[er] && 340 != o1[er].epos[0] - 1 + el[er] && 360 != o1[er].epos[0] - 1 + el[er] && 380 != o1[er].epos[0] - 1 + el[er] && 400 != o1[er].epos[0] - 1 + el[er] && 420 != o1[er].epos[0] - 1 + el[er] && 440 != o1[er].epos[0] - 1 + el[er] && 460 != o1[er].epos[0] - 1 + el[er] && 480 != o1[er].epos[0] - 1 + el[er]) {

                                for (int i = 0; i < 6; i++) {

                                    for (int j = 0; j < 6; j++) {

                                        if ((pos[j] + l == o1[er].epos[i] - 1 + el[er])) {
                                            ego = 0;
                                        }
                                    }
                                }

                                for (int k = 0; k < 3; k++) {
                                    for (int i = 0; i < 6; i++) {
                                        for (int j = 0; j < 6; j++) {

                                            if (k != er) {
                                                if ((o1[er].epos[i] - 1 + el[er] == o1[k].epos[j] + el[k])) {
                                                    ego = 0;
                                                }
                                            }
                                        }
                                    }
                                }

                                if (ego == 1) {
                                    el[er] -= 1;
                                }
                            } else {
                                estr[er] = "Down";
                            }

                            break;

                        case 3:

                            o1[er].epos[0] += -2;
                            o1[er].epos[1] += 40;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += -40;
                            o1[er].epos[4] += 42;
                            o1[er].epos[5] += -38;
                            break;

                    }
                    eprePos[er] = 2;

                } else if (estr[er].equals("Right")) {
                    switch (eprePos[er]) {
                        case 0:                      //up
                            o1[er].epos[0] += 21;
                            o1[er].epos[1] += -19;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += 19;
                            o1[er].epos[4] += -40;
                            o1[er].epos[5] += -2;
                            break;
                        case 1:                  //down

                            o1[er].epos[0] += -19;
                            o1[er].epos[1] += -21;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += 21;
                            o1[er].epos[4] += -2;
                            o1[er].epos[5] += 40;

                            break;

                        case 2:                      //left

//
                            o1[er].epos[0] += 2;
                            o1[er].epos[1] += -40;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += 40;
                            o1[er].epos[4] += -42;
                            o1[er].epos[5] += 38;

                            break;

                        case 3:                      //right

                            int ego = 1;
                            if (19 != o1[er].epos[0] + 1 + el[er] && 39 != o1[er].epos[0] + 1 + el[er] && 59 != o1[er].epos[0] + 1 + el[er] && 79 != o1[er].epos[0] + 1 + el[er] && 99 != o1[er].epos[0] + 1 + el[er] && 119 != o1[er].epos[0] + 1 + el[er] && 139 != o1[er].epos[0] + 1 + el[er] && 159 != o1[er].epos[0] + 1 + el[er] && 179 != o1[er].epos[0] + 1 + el[er] && 199 != o1[er].epos[0] + 1 + el[er] && 219 != o1[er].epos[0] + 1 + el[er] && 239 != o1[er].epos[0] + 1 + el[er] && 259 != o1[er].epos[0] + 1 + el[er] && 279 != o1[er].epos[0] + 1 + el[er] && 299 != o1[er].epos[0] + 1 + el[er] && 319 != o1[er].epos[0] + 1 + el[er] && 339 != o1[er].epos[0] + 1 + el[er] && 359 != o1[er].epos[0] + 1 + el[er] && 379 != o1[er].epos[0] + 1 + el[er] && 399 != o1[er].epos[0] + 1 + el[er] && 419 != o1[er].epos[0] + 1 + el[er] && 439 != o1[er].epos[0] + 1 + el[er] && 459 != o1[er].epos[0] + 1 + el[er] && 479 != o1[er].epos[0] + 1 + el[er] && 499 != o1[er].epos[0] + 1 + el[er]) {
                                for (int i = 0; i < 6; i++) {
                                    for (int j = 0; j < 6; j++) {
                                        if ((pos[j] + l == o1[er].epos[i] + 1 + el[er])) {
                                            ego = 0;
                                        }
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    for (int i = 0; i < 6; i++) {
                                        for (int j = 0; j < 6; j++) {

                                            if (k != er) {
                                                if (o1[er].epos[i] + 1 + el[er] == o1[k].epos[j] + el[k]) {
                                                    ego = 0;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (ego == 1) {
                                    el[er] += 1;
                                }
                            } else {
                                estr[er] = "Up";
                            }

                            break;

                    }
                    eprePos[er] = 3;

                } else if (estr[er].equals("Up")) {
                    switch (eprePos[er]) {
                        case 0:                      //up

                            int ego = 1;

                            if (1 != o1[er].epos[0] - 20 + el[er] && 2 != o1[er].epos[0] - 20 + el[er] && 3 != o1[er].epos[0] - 20 + el[er] && 4 != o1[er].epos[0] - 20 + el[er] && 5 != o1[er].epos[0] - 20 + el[er] && 6 != o1[er].epos[0] - 20 + el[er] && 7 != o1[er].epos[0] - 20 + el[er] && 8 != o1[er].epos[0] - 20 + el[er] && 9 != o1[er].epos[0] - 20 + el[er] && 10 != o1[er].epos[0] - 20 + el[er] && 11 != o1[er].epos[0] - 20 + el[er] && 12 != o1[er].epos[0] - 20 + el[er] && 13 != o1[er].epos[0] - 20 + el[er] && 14 != o1[er].epos[0] - 20 + el[er] && 15 != o1[er].epos[0] - 20 + el[er] && 16 != o1[er].epos[0] - 20 + el[er] && 17 != o1[er].epos[0] - 20 + el[er] && 18 != o1[er].epos[0] - 20 + el[er] && 19 != o1[er].epos[0] - 20 + el[er]) {
                                for (int i = 0; i < 6; i++) {
                                    for (int j = 0; j < 6; j++) {
                                        if ((pos[j] + l == o1[er].epos[i] - 20 + el[er])) {
                                            ego = 0;
                                        }
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    for (int i = 0; i < 6; i++) {
                                        for (int j = 0; j < 6; j++) {
                                            if (k != er) {
                                                if (o1[er].epos[i] - 20 + el[er] == o1[k].epos[j] + el[k]) {
                                                    ego = 0;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (ego == 1) {
                                    el[er] -= 20;
                                }
                            } else {
                                estr[er] = "Left";
                            }

                            break;

                        case 1:                  //down

                            o1[er].epos[0] += -40;
                            o1[er].epos[1] += -2;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += 2;
                            o1[er].epos[4] += 38;
                            o1[er].epos[5] += 42;

                            break;

                        case 2:                      //left

                            o1[er].epos[0] += -19;
                            o1[er].epos[1] += -21;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += 21;
                            o1[er].epos[4] += -2;
                            o1[er].epos[5] += 40;

                            break;

                        case 3:                      //right

                            o1[er].epos[0] += -21;
                            o1[er].epos[1] += 19;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += -19;
                            o1[er].epos[4] += 40;
                            o1[er].epos[5] += 2;

                            break;

                    }
                    eprePos[er] = 0;
                } else if (estr[er].equals("Down")) {
                    switch (eprePos[er]) {
                        case 0:                      //up

//
                            o1[er].epos[0] += 40;
                            o1[er].epos[1] += 2;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += -2;
                            o1[er].epos[4] += -38;
                            o1[er].epos[5] += -42;

                            break;
                        case 1:                  //down

                            int ego = 1;

                            if (501 != o1[er].epos[0] + 20 + el[er] && 502 != o1[er].epos[0] + 20 + el[er] && 503 != o1[er].epos[0] + 20 + el[er] && 504 != o1[er].epos[0] + 20 + el[er] && 505 != o1[er].epos[0] + 20 + el[er] && 506 != o1[er].epos[0] + 20 + el[er] && 507 != o1[er].epos[0] + 20 + el[er] && 508 != o1[er].epos[0] + 20 + el[er] && 509 != o1[er].epos[0] + 20 + el[er] && 510 != o1[er].epos[0] + 20 + el[er] && 511 != o1[er].epos[0] + 20 + el[er] && 512 != o1[er].epos[0] + 20 + el[er] && 513 != o1[er].epos[0] + 20 + el[er] && 514 != o1[er].epos[0] + 20 + el[er] && 515 != o1[er].epos[0] + 20 + el[er] && 516 != o1[er].epos[0] + 20 + el[er] && 517 != o1[er].epos[0] + 20 + el[er] && 518 != o1[er].epos[0] + 20 + el[er] && 519 != o1[er].epos[0] + 20 + el[er]) {
                                for (int i = 0; i < 6; i++) {
                                    for (int j = 0; j < 6; j++) {
                                        if ((pos[j] + l == o1[er].epos[i] + 20 + el[er])) {
                                            ego = 0;
                                        }
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    for (int i = 0; i < 6; i++) {
                                        for (int j = 0; j < 6; j++) {

                                            if (k != er) {
                                                if (o1[er].epos[i] + 20 + el[er] == o1[k].epos[j] + el[k]) {
                                                    ego = 0;
                                                }
                                            }

                                        }
                                    }
                                }
                                if (ego == 1) {
                                    el[er] += 20;
                                }
                            } else {
                                estr[er] = "Right";
                            }

                            break;

                        case 2:                      //left

                            o1[er].epos[0] += 21;
                            o1[er].epos[1] += -19;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += 19;
                            o1[er].epos[4] += -40;
                            o1[er].epos[5] += -2;
                            break;

                        case 3:                      //right

                            o1[er].epos[0] += 19;
                            o1[er].epos[1] += 21;
                            o1[er].epos[2] += 0;
                            o1[er].epos[3] += -21;
                            o1[er].epos[4] += 2;
                            o1[er].epos[5] += -40;

                            break;

                    }
                    eprePos[er] = 1;
                } else if (estr[er].equals("Space") && espace[er]) {

                    eflag[er] = true;
                    espace[er] = false;
                    drawebulLet();
                    t[er] = 0;
                }
            }

        }
    }
}
