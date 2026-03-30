import { useState, useEffect } from 'react';
import axios from 'axios';

function ListeAppartements() {
  const [appartements, setAppartements] = useState([]);

  useEffect(() => {
    // L'appel à ton API Spring Boot
    axios.get('http://localhost:8080/appartements/')
      .then(response => {
        setAppartements(response.data);
      })
      .catch(error => {
        console.error("Erreur axios :", error);
      });
  }, []);

  return (
    <div>
      <h2>Liste des Appartements</h2>
      {appartements.length === 0 ? (
        <p>Aucun appartement trouvé ou chargement en cours...</p>
      ) : (
        <ul>
          {appartements.map(appart => (
            <li key={appart.id}>
              <strong>Apt {appart.numero}</strong> - {appart.surface} m² 
              (Description : {appart.description})
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default ListeAppartements;