import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const API = "http://localhost:9008";

export default function ListeAppartements() {
  const [appartements, setAppartements] = useState([]);
  const [loading, setLoading] = useState(true);
  const [erreur, setErreur] = useState(null);

  useEffect(() => {
    fetch(`${API}/appartements/`)
      .then((res) => {
        if (!res.ok) throw new Error("Erreur lors du chargement");
        return res.json();
      })
      .then((data) => {
        setAppartements(data);
        setLoading(false);
      })
      .catch((err) => {
        setErreur(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <p className="message-chargement">Chargement...</p>;
  if (erreur) return <p className="message-erreur">Erreur : {erreur}</p>;

  return (
    <div className="page">
      <h1>Appartements</h1>
      <div className="appart-grid">
        {appartements.map((appart, index) => (
          <div key={index} className="appart-card">
            <div className="appart-header">
              <span className="appart-numero">Appt n°{appart.numero ?? "—"}</span>
              {appart.surface && (
                <span className="badge">{appart.surface} m²</span>
              )}
            </div>
            <p className="appart-description">{appart.description || "Aucune description"}</p>
            <Link to={`/appartements/${appart.id ?? index}`} className="btn">
              Voir la fiche
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
}