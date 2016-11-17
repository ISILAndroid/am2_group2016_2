# am2_group2016_2 Lesson8

Conexión Remota (S7-S8)
  
  # Requisitos 
    1. Cuenta en BackendLess
    2. Postman [https://www.getpostman.com/](https://www.getpostman.com/)
    3. Json Editor [http://www.jsoneditoronline.org/#/](http://www.jsoneditoronline.org/#/)
    4. Http Status [https://httpstatuses.com/](https://httpstatuses.com/)
    
  # Pasos 
  1. Guardar una nota
    - Documentación :
    https://backendless.com/documentation/data/rest/data_saving_data_objects.htm
    
    URL : ``` https://api.backendless.com/<version>/data/<table-name>```
    
    Path : https://api.backendless.com/v1/data/Notes
    
    Method: POST
    
    Request Header :
    ```
      application-id: app-id-value
      secret-key: secret-key-value
      Content-Type:application/json
      application-type: REST
    ```
    
    Request Body :
    ```
      {
       "name" : value,
       "description" : value,
      }
    ```
    Response Body :
    
    ```
        {
          "created": 1465426355000,
          "name": "nota desde android",
          "___class": "Notes",
          "description": "esta es una nota de prueba",
          "ownerId": null,
          "updated": null,
          "objectId": "F9E7E58F-4409-08CB-FFCB-64D5BB741100",
          "__meta": "{\"relationRemovalIds\":{},\"selectedProperties\":[\"created\",\"___saved\",\"name\",\"___class\",\"description\",\"ownerId\",\"updated\",\"objectId\"],\"relatedObjects\":{}}"
        }
    ```
   Pruebas en Postman
   
   4. Login
   ![](https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson8/postman_login_headers.PNG)
   ![](https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson8/postman_login_request.PNG)
   ![](https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson8/postman_login_response.PNG)
   
  


