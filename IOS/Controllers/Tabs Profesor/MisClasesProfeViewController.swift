//
//  MisClasesProfeViewController.swift
//  20plus
//
//  Created by Alumnos on 16/06/18.
//  Copyright © 2018 renato. All rights reserved.
//

import UIKit
import Alamofire
import SwiftyJSON
class MisClasesProfeViewController: UITableViewController {

    var tutoriaIds = [Int]()
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
        let id : Int = userDefaults.integer(forKey: "UserId")
        var idprofe = ""
        var idhorario = 0
        idprofe = String(id)
        Alamofire.request("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesor_horario").responseJSON{
            response in
            if let json1 = response.result.value{
                let sJSON1 = JSON(json1)
                for(_,subJson1):(String, JSON) in sJSON1{
                    if(subJson1["id_profesor"].intValue==id){
                    idhorario=subJson1["id"].intValue
                    self.tutoriaIds.append(subJson1["id"].intValue)
                    }
                }}
            for index in self.tutoriaIds{
        Alamofire.request("http://vmdev1.nexolink.com:90/TeachersAPI/api/tutorias").responseJSON{
            response in
            if let json = response.result.value{
                let sJSON = JSON(json)
                for(_,subJson):(String, JSON) in sJSON{
                    if(subJson["id_horario"].intValue==index){
                    let objEntidad = tutoria()
                    objEntidad.idtutoria=subJson["idtutoria"].intValue
                    objEntidad.comentario=subJson["comentario"].stringValue
                    objEntidad.curso=subJson["curso"].stringValue
                    objEntidad.estado=subJson["estado"].stringValue
                    objEntidad.numerohoras=subJson["numerohoras"].intValue
                    objEntidad.precio=subJson["precio"].doubleValue
                    self.arreglo.append(objEntidad)
                    }
                }
                self.tableView.reloadData()
            }}} }}
        
        
        

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        
        
        //commit random
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return arreglo.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "celdas", for: indexPath)

        // Configure the cell...
        cell.textLabel?.text=arreglo[indexPath.row].curso + "-" + arreglo[indexPath.row].estado
        selectedRow = indexPath.row
        return cell
    }
 
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        if( segue.identifier == "ver" ){
            if let controller = segue.destination as? VerClaseViewController2 {
                controller.clase = arreglo[self.selectedRow].idtutoria
            }
        }
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        //print(myItems[indexPath.row].name)
        self.selectedRow = indexPath.row
        self.performSegue(withIdentifier: "ver", sender: self)
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
