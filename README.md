Layers

## Request
Este objeto es una estructura de datos que nos permite tener un panorama claro de los campos requeridos en un request.

## Use case
Esta es una inferfaz que utilizamos como contrato para inputs de nuestro sistema.

## Service
Este es un componente que implementa el contrato declarado por el caso de uso, se encarga de orquestrar las entidades, repositorios y validar las reglas del negocio.

## Entity
Esta entidad define los objetos claves del sistema utilizados por nuestros servicios para implementar el flujo de la aplicación.

## Repositorios
Este componente nos permite definir la manera de persistir nuestra información en algún servicio pudiendo ser SQL o NoSQL por ejemplo.

## DAO
Este objeto nos permite mappear nuestra tabla o entidad de almacenamiento de datos para persistir o recuperar información.

## Mapper
Este objeto nos permite transformar un objeto de cierto tipo a otro objeto de otro tipo, será usado generalmente para transformar un DAO a una Entity y viseversa.

## Response
Este objeto será utilizado por nuestros servicios y nos permite transportar información desde nuestro dominio hacía los controladores.

## Listeners
Esta es una interfaz que debe ser implementada por el Listener que escuchará eventos de alguna queue.

## Broadcasters
Esta es una interfaz que debe ser implementada por un evento que se enviará a una cola de mensajes.

## Emitters
Este paquete contiene una interfaz que debe ser implementada por un broker de envío de mensajes, es utilizada por el broadcaster.

## Events
Contiene los modelos que mapean mensajes de queues de entrada y salida, se separan entre in y out para mejor separación de los mismos.

## Command
Es una entidad que contiene el mapeo de un request a una estructura de datos requerida por el caso de uso para funcionar.

## Response
Es una estructura de datos utilizada en los services para mappear los modelos a una respuesta esperada por el controlador.