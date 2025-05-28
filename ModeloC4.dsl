workspace "Sistema de gestión de ordenes de produccion"  {
    description "Sistema de gestión de ordenes de produccion"
    
    model {
        personaClienteExterno = person "clienteExterno"
        pGerente = person "gerente"
        pclienteInterno = person "ClienteInterno"
        
        sSistemaProduccion = softwareSystem "Sistema de gestión de ordenes de produccion" {
            tags "Software"
        }
        
        sGestion = softwareSystem "Plataforma de gestion" {
            tags "SistemaGestion"
            
            portalClienteExterno = container "Pagina de visualización" {
                tags "AppWeb"
                personaClienteExterno  -> this "Visualiza estado de orden de produccion"
            }
            
            portalClienteInterno = container "Pagina de ordenes de produccion" {
                tags "AppWeb"
                pclienteInterno -> this "crea orden produccion "
                pGerente -> this "revisa reportes de ordenes de produccion"
            }
            
            api = container "API" {
                tags "Api"
                portalClienteInterno -> this "Generacion"
                portalClienteExterno -> this "Consulta"
                this -> sSistemaProduccion "revisa reportes de ordenes de produccion"
                
                emailComponente  = component "Email-componente" "Envia notificaciones a los clientes finales"
                
                incresoComponente = component "Controlador de ingreso" "Permite el ingreso a los clientes internos"
            }
            
            basedatos = container "Base de datos" {
                tags "Database"
                api -> this "Obtener/Crear/Actualizar/Eliminar"
            }
        }
    }
    
    views {
        systemContext sGestion {
            include *
            autolayout lr
        }
        
        container sGestion {
            include *
            autolayout lr
        }
        
        component api "Componentes" {
            include *
            autolayout lr
        }
        
        styles {
            element "SistemaGestion" {
                shape Circle
                background #19b92a
                color #000000
            }
        }
        
        theme "https://srv-si-001.utpl.edu.ec/REST_PRO_ERP/Recursos/Imagenes/themeAZ_2023.json"
    }
}
