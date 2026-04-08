import { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";

const API = "http://localhost:9008";

export default function DetailAppartement() {
  const { id } = useParams();

  const [appartement, setAppartement] = useState(null);
  const [contrats, setContrats] = useState([]);
  const [interventions, setInterventions] = useState([]);
  const [loading, setLoading] = useState(true);
  const [erreur, setErreur] = useState(null);

  useEffect(() => {
    const fetchAppart = fetch(`${API}/appartements/${id}`).then((r) => r.json());
    const fetchContrats = fetch(`${API}/api/contrats`).then((r) => r.json());
    const fetchInterventions = fetch(`${API}/interventions/appartement/${id}`)
      .then((r) => (r.ok ? r.json() : []))
      .catch(() => []);

    Promise.all([fetchAppart, fetchContrats, fetchInterventions])
      .then(([appart, tousContrats, interventionsData]) => {
        setAppartement(appart);
        const contratsAppart = tousContrats.filter(
          (c) => String(c.appartementId) === String(id)
        );
        setContrats(contratsAppart);
        setInterventions(interventionsData);
        setLoading(false);
      })
      .catch((err) => {
        setErreur(err.message);
        setLoading(false);
      });
  }, [id]);

  if (loading) return <p className="message-chargement">Chargement...</p>;
  if (erreur) return <p className="message-erreur">Erreur : {erreur}</p>;
  if (!appartement) return <p className="message-chargement">Appartement introuvable.</p>;

  const contratActif = contrats.find(
    (c) => !c.dateFin || new Date(c.dateFin) >= new Date()
  );

  return (
    <div className="page-detail">
      <Link to="/appartements" className="retour">← Retour à la liste</Link>

      {/* Infos appartement */}
      <div className="card">
        <h2>Appartement n°{appartement.numero ?? "—"}</h2>
        <div className="info-grid">
          <span className="info-label">Surface</span>
          <span className="info-valeur">{appartement.surface ? `${appartement.surface} m²` : "—"}</span>

          <span className="info-label">Nb pièces</span>
          <span className="info-valeur">{appartement.nbpieces ?? "—"}</span>

          <span className="info-label">Description</span>
          <span className="info-valeur">{appartement.description || "Aucune"}</span>

          <span className="info-label">Bâtiment</span>
          <span className="info-valeur">{appartement.batimentId ? `ID ${appartement.batimentId}` : "—"}</span>
        </div>
      </div>

      {/* Locataire actuel */}
      <div className="card">
        <h2>Locataire actuel</h2>
        {contratActif ? (
          <div className="info-grid">
            <span className="info-label">N° bail</span>
            <span className="info-valeur">{contratActif.numeroBail ?? "—"}</span>

            <span className="info-label">Début</span>
            <span className="info-valeur">{contratActif.dateDebut ?? "—"}</span>

            <span className="info-label">Fin</span>
            <span className="info-valeur">{contratActif.dateFin ?? "En cours"}</span>

            <span className="info-label">Loyer (HC)</span>
            <span className="info-valeur">{contratActif.loyersanscharge ? `${contratActif.loyersanscharge} €` : "—"}</span>

            <span className="info-label">Charges</span>
            <span className="info-valeur">{contratActif.montantcharge ? `${contratActif.montantcharge} €` : "—"}</span>
          </div>
        ) : (
          <p className="vide">Aucun locataire actif pour cet appartement.</p>
        )}
      </div>

      {/* Interventions */}
      <div className="card">
        <h2>Interventions</h2>
        {interventions.length === 0 ? (
          <p className="vide">Aucune intervention enregistrée.</p>
        ) : (
          <div className="intervention-liste">
            {interventions.map((interv, i) => (
              <div key={i} className="intervention-item">
                <span className="intervention-date">{interv.date ?? "—"}</span>
                <span className="intervention-desc">{interv.description ?? "Sans description"}</span>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}