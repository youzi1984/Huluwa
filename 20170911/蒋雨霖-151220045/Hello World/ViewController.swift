//
//  ViewController.swift
//  Hello World
//
//  Created by jimmy233 on 2017/9/11.
//  Copyright © 2017年 NJU. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var HelloLable: UILabel!

    @IBAction func ButtonPressed(_ sender: UIButton) {
        let title = sender.title(for: .normal)!
        HelloLable.text="\(title)"
    }
}

