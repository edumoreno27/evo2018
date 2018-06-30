//
//  VerTutoriasPadreTableViewController.swift
//  20plus
//
//  Created by renato mercado luna on 6/29/18.
//  Copyright © 2018 renato. All rights reserved.
//

import UIKit
import Alamofire
import SwiftyJSON

class VerTutoriasPadreTableViewController: UITableViewController {

    
    
    var id = 0
    var arreglo = [tutoria]()
    var selectedRow: Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    
    override func viewDidAppear(_ animated: Bool) {
        
        
        let userDefaults = UserDefaults.standard
        let userId : Int = userDefaults.integer(forKey: "UserId")
        
        Alamofire.request("http://vmdev1.nexolink.com:90/TeachersAPI/api/tutorias?idpadre=" + String(userId)).responseJSON{
            response in
            if let json = response.result.value{
                let sJSON = JSON(json)
                for(_,subJson):(String, JSON) in sJSON{
                    let objEntidad = tutoria()
                    objEntidad.id_padre=subJson["id_padre"].intValue
                    objEntidad.hora=subJson["hora"].stringValue
                    objEntidad.numerohoras=subJson["numerohoras"].intValue
                    objEntidad.curso = subJson["curso"].stringValue
                    objEntidad.estado = subJson["estado"].stringValue
                    self.arreglo.append(objEntidad)
                }
                self.tableView.reloadData()
            }
        }
    }

    

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return arreglo.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "tuto cell", for: indexPath)

        // Configure the cell...
        cell.textLabel?.text=" Para la hora " + arreglo[indexPath.row].hora + " el curso " + arreglo[indexPath.row].curso
        return cell
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        if( segue.identifier == "detailTUTORIA" ){
            if let controller = segue.destination as? tutoriaMarcadaViewController {
                controller.tutoria = arreglo[self.selectedRow]
            }
        }
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        //print(myItems[indexPath.row].name)
        self.selectedRow = indexPath.row
        self.performSegue(withIdentifier: "detailTUTORIA", sender: self)
    }

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
